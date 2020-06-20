package MultiBufferLockAndCondition;

import java.util.concurrent.locks.*;

public class MonitorMultiBuffer2 {

	
	
	private int MAX = 10;
	private volatile ProductoMultiBuffer2[] p = null;
	private volatile int front, rear, count;
	private volatile boolean vacio = true, lleno = false;
	
	
	final Lock lock;
	final Condition colaProductores; //cola de espera de hilos productores
	final Condition colaConsumidores; //cola de espera de hilos consumidores
	
	
	public MonitorMultiBuffer2() {
		this.front = 0;this.count = 0;this.rear = 0;
		this.p = new ProductoMultiBuffer2[MAX];
		
		this.lock = new ReentrantLock();
		this.colaProductores = lock.newCondition();
		this.colaConsumidores = lock.newCondition();
		
	}
	
	public ProductoMultiBuffer2[] getP(int idCon, int length) {
		
		lock.lock();

		while(vacio || length > count)
			try {
				colaConsumidores.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		ProductoMultiBuffer2 ret[] = new ProductoMultiBuffer2[length];
		System.out.println("Consumidor " + idCon + "consume " + length + ":");
		for(int i = 0; i < length; i++) {
			ret[i] = this.p[front];
			this.p[front] = null; this.p = this.p;
			System.out.println("producto " + ret[i].id);
			this.front = (this.front+1) % MAX;
			this.count--;
			
		}
		vacio = (count == 0);
		lleno =  false;

		colaProductores.signal();
		lock.unlock();
		return ret;
	}
	
	public  void put(ProductoMultiBuffer2[] pro, int idProd, int length) {
		
		lock.lock();
		while(lleno || length > (MAX - this.count))
			try {
				colaProductores.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Productor " + idProd + " produce " + length + ":");
		for(int i = 0; i < length; i++) {
			
			this.p[rear] = pro[i]; this.p = this.p;
			System.out.println("Producto " + pro[i].id  + " creado");
			this.rear = (rear+1) % MAX;
			this.count++;
			
		}
		lleno = (count == MAX);
		vacio = false;
		colaConsumidores.signal();
		lock.unlock();
		
	}
}

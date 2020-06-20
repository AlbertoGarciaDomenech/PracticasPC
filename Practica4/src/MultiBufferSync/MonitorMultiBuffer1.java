package MultiBufferSync;

public class MonitorMultiBuffer1 {

	
	
	private int MAX = 15;
	private volatile ProductoMultiBuffer1[] p = null;
	private volatile int front, rear, count;
	private volatile boolean vacio = true, lleno = false;
	
	
	
	public MonitorMultiBuffer1() {
		this.front = 0;this.count = 0;this.rear = 0;
		this.p = new ProductoMultiBuffer1[MAX];
	}
	
	public synchronized ProductoMultiBuffer1[] getP(int idCon, int length) {
	
		while(vacio || length > count)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		ProductoMultiBuffer1 ret[] = new ProductoMultiBuffer1[length];
		System.out.println("Consumidor " + idCon + "consume " + length + "productos:");
		for(int i = 0; i < length; i++) {
			ret[i] = this.p[front];
			this.p[front] = null; this.p = this.p;
			System.out.println("producto " + ret[i].id);
			this.front = (this.front+1) % MAX;
			this.count--;
			
		}
		
		
		vacio = (count == 0);
		lleno =  false;
		notifyAll();
		return ret;
	}
	
	public synchronized void put(ProductoMultiBuffer1[] pro, int idProd, int length) {
		while(lleno || length > (MAX - this.count))
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Productor " + idProd + "produce " + length + ":");
		for(int i = 0; i < length; i++) {

			this.p[rear] = pro[i]; this.p = this.p;
			System.out.println(pro[i].id  + " creado");
			this.rear = (rear+1) % MAX;
			this.count++;
			
		}
		lleno = (count == MAX);
		vacio = false;
		notifyAll();
	}
}

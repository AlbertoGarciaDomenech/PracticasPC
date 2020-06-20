package ProdCon;

public class MonitorProdCon {

	
	
	private int MAX = 10;
	private volatile Producto[] p = null;
	private volatile int front, rear, count;
	private volatile boolean vacio = true, lleno = false;
	
	
	
	public MonitorProdCon() {
		this.front = 0;this.count = 0;this.rear = 0;
		this.p = new Producto[MAX];
	}
	
	public synchronized Producto getP(int idCon) {
	
		while(vacio)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		Producto ret = this.p[front];
		this.p[front] = null; this.p = this.p;
		System.out.println("Consumidor " + idCon + "consume producto " + ret.id);
		
		this.front = (this.front+1) % MAX;
		this.count--;
		
		vacio = (count == 0);
		lleno =  false;
		notifyAll();
		return ret;
	}
	
	public synchronized void put(Producto pro, int idProd) {
		while(lleno)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.p[rear] = pro; this.p = this.p;
		System.out.println("Productor " + idProd + ": Producto " + pro.id  + " creado");
		this.rear = (rear+1) % MAX;
		this.count++;
		lleno = (count == MAX);
		vacio = false;
		notifyAll();
	}
}

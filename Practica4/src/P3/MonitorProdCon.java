package P3;

public class MonitorProdCon {

	
	//check https://programaressencillo.wordpress.com/2014/11/25/java-monitores-ejemplo-productor-consumidor/
	
	private int MAX = 10;
	private volatile Producto[] p;
	private int front, rear, count;
	private boolean lleno = false;
	
	public MonitorProdCon() {
		this.front = 0;
		this.count = 0;
		this.rear = (this.front + this.count) % MAX;
		this.p = new Producto[MAX];
	}
	
	synchronized Producto getP() throws InterruptedException {
	
		while(!lleno) wait();
		Producto ret = p[front];
		this.front++;
		if(front == MAX)front = 0;
		this.rear = (this.front + this.count) % MAX;
		lleno = (front == rear);
		notify();
		return ret;
	}
	
	synchronized void put(Producto pro, int idProd) throws InterruptedException {
		while(lleno) wait();
		this.p[rear] = pro;
		System.out.println("Productor " + idProd + ": Producto " + this.p[rear].id + " creado");
		this.count++;
		this.rear = (this.front + this.count) % MAX;
		lleno = (front == rear);
		
		notify();
	}
}

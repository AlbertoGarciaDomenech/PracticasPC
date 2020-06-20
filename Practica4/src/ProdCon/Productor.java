package ProdCon;

public class Productor extends Thread{

	private Producto p;
	private MonitorProdCon monitor;
	private int id;
	private Dato dato;
	
	public Productor(int _id, MonitorProdCon _m,Dato _d) {
		this.monitor = _m;
		this.id = _id;
		dato = _d;
	}
	
	
	public void run() {
		int i = 0;
			while(true) {
				this.p = new Producto(dato.numProd++);
				this.monitor.put(this.p, this.id);
				
				//i++;
			}
		}
}

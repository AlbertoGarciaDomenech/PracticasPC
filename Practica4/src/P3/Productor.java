package P3;

public class Productor extends Thread{

	private Producto p;
	private MonitorProdCon monitor;
	private int id;
	
	public Productor(int _id, MonitorProdCon _m) {
		this.monitor = _m;
		this.id = _id;
	}
	
	
	public void run() {
		int i = 0;
			while(i < 10) {
				this.p = new Producto(i);
				try {
					this.monitor.put(this.p, this.id);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				i++;
			}
		}
}

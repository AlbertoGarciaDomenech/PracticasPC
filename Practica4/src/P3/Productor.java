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
			while(i < 20) {
				this.p = new Producto(this.id * 10 +i);
				try {
					this.monitor.put(this.p, this.id);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				i++;
			}
		}
}

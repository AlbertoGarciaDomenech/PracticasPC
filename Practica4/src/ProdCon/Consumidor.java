package ProdCon;


public class Consumidor extends Thread{

	private MonitorProdCon monitor;
	private int id;
	
	public Consumidor(int idConsumidor, MonitorProdCon _m) {
		this.id = idConsumidor;
		this.monitor = _m;
	}
	
	public void run() {
	int i = 0;
		
		while(true) {
			Producto prod = monitor.getP(this.id);
			//i++;
		}
	}
	
}

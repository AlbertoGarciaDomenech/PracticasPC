package P3;


public class Consumidor extends Thread{

	private MonitorProdCon monitor;
	private int id;
	
	public Consumidor(int idConsumidor, MonitorProdCon _m) {
		this.id = idConsumidor;
		this.monitor = _m;
	}
	
	public void run() {
	int i = 0;
		
		while(i < 10) {
				
			Producto prod;
			try {
				prod = monitor.getP();
				System.out.println("Consumidor " + this.id + "coge producto " + prod.id);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

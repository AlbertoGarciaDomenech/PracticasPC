package MultiBufferSync;


public class ConsumidorMultiBuffer1 extends Thread{

	private MonitorMultiBuffer1 monitor;
	private int id;
	private int length;
	
	public ConsumidorMultiBuffer1(int idConsumidor, MonitorMultiBuffer1 _m, int _l) {
		this.id = idConsumidor;
		this.monitor = _m;
		this.length = _l;
	}
	
	public void run() {
	int i = 0;
		
		while(true) {
			ProductoMultiBuffer1 prod[] = monitor.getP(this.id, this.length);
			//i++;
		}
	}
	
}

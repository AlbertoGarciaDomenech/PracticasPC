package MultiBufferLockAndCondition;


public class ConsumidorMultiBuffer2 extends Thread{

	private MonitorMultiBuffer2 monitor;
	private int id;
	private int length;
	
	public ConsumidorMultiBuffer2(int idConsumidor, MonitorMultiBuffer2 _m, int _l) {
		this.id = idConsumidor;
		this.monitor = _m;
		this.length = _l;
	}
	
	public void run() {
	int i = 0;
		
		while(true) {
			ProductoMultiBuffer2 prod[] = monitor.getP(this.id, this.length);
			//i++;
		}
	}
	
}

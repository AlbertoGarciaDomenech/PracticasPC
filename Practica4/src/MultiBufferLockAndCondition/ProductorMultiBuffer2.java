package MultiBufferLockAndCondition;

public class ProductorMultiBuffer2 extends Thread{

	private ProductoMultiBuffer2[] p;
	private MonitorMultiBuffer2 monitor;
	private int id, length;
	private DatoMultiBuffer2 dato;
	
	public ProductorMultiBuffer2(int _id, MonitorMultiBuffer2 _m,DatoMultiBuffer2 _d, int _l) {
		this.monitor = _m;
		this.id = _id;
		this.dato = _d;
		this.length = _l;
	}
	
	
	public void run() {
		int i = 0;
			while(true) {
				p = new ProductoMultiBuffer2[this.length];
				for(int j = 0; j < length; j++) {
					
					this.p[j] = new ProductoMultiBuffer2(dato.numProd++);
				}
				this.monitor.put(this.p, this.id, this.length);
				
				//i++;
			}
		}
}

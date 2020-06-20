package MultiBufferSync;

public class ProductorMultiBuffer1 extends Thread{

	private ProductoMultiBuffer1[] p;
	private MonitorMultiBuffer1 monitor;
	private int id, length;
	private DatoMultiBuffer1 dato;
	
	public ProductorMultiBuffer1(int _id, MonitorMultiBuffer1 _m,DatoMultiBuffer1 _d, int _l) {
		this.monitor = _m;
		this.id = _id;
		this.dato = _d;
		this.length = _l;
	}
	
	
	public void run() {
		int i = 0;
			while(true) {
				p = new ProductoMultiBuffer1[this.length];
				for(int j = 0; j < length; j++) {
					
					this.p[j] = new ProductoMultiBuffer1(dato.numProd++);
				}
				this.monitor.put(this.p, this.id, this.length);
				
				//i++;
			}
		}
}

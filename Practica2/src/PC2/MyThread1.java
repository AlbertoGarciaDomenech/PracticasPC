package PC2;

public class MyThread1 extends Thread {
	private DatosCompartidos dato;

	public int id;
	
	public MyThread1(DatosCompartidos dato, int id) {
		this.dato = dato;
		this.id = id;
	}
	
	public void run(){
		
		for(int i = 0; i < 3000; i++) {
			dato.lock.takeLock(id);
			dato.num++;
			dato.lock.releaseLock(id);
		}
		
//		for(int i = 0; i < 3000; i++) {
//			dato.inInc = true;
//			dato.last = 1;
//			while(dato.inDec && dato.last == 1) {}
//			dato.num++;
//			dato.inInc = false;
//		}
	}
}

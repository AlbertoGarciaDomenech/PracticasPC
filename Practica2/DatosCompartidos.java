package PC2;

public class DatosCompartidos {
	
	volatile public int num;
	volatile public int last;
	volatile public boolean ininc = false;
	volatile public boolean indec = false;
	volatile public Lock lock;
	
//	volatile public boolean inInc = false, inDec=false;
//	volatile public int last;
	
	public DatosCompartidos(Lock L, int n) {
		this.num = n;
		this.lock = L;
	}
	
}
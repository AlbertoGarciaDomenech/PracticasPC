package PC2;

public class Main {

	public static void main(String[] args) throws InterruptedException{
			
		int N = 5;
		DatosCompartidos dato = new DatosCompartidos(new LockRompeEmpate(2*N), 0);
		Thread[] hilosInc = new Thread[N];
		Thread[] hilosDec = new Thread[N];

		for(int i = 0; i < N; i++) {
			hilosInc[i] = new MyThread1(dato, 2*i);
			hilosInc[i].start();
			hilosDec[i] = new MyThread2(dato, 2*i+1);
			hilosDec[i].start();
		}
		for(int i = 0; i < N; i++) {
			hilosInc[i].join();
			hilosDec[i].join();
		}
		
		System.out.println(dato.num);
		System.err.println("Acaba");
	}
}

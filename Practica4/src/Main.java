public class Main {

	public static void main(String[] args) throws InterruptedException {
		int N = 3000;
		Monitor monitor = new Monitor();
		Thread[] hilosInc = new Thread[N];
		Thread[] hilosDec = new Thread[N];
		for(int i = 0; i < N; i++) {
			hilosInc[i] = new ThreadInc(monitor);
			hilosInc[i].start();
			hilosDec[i] = new ThreadDec(monitor);
			hilosDec[i].start();
		}
		for(int i = 0; i < N; i++) {
			hilosInc[i].join();
			hilosDec[i].join();
		}
		
		System.out.println(monitor.getNum());
		System.err.println("Acaba");
	}

}


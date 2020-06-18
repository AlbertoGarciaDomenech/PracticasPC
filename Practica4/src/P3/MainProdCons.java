package P3;

public class MainProdCons {
	
	public static void main(String[] args) throws InterruptedException {

		int N = 10;					 	// Num Productores
		int M = 10;						// Num Consumidores
		MonitorProdCon monitor = new MonitorProdCon();
		Thread[] productores = new Thread[N];
		Thread[] consumidores = new Thread[M];
		
		for(int i = 0; i < N; i++) {
			productores[i] = new Productor(i,monitor);
			productores[i].start();
		}
		for(int i = 0; i < M; i++) {
			consumidores[i] = new Consumidor(i,monitor);
			consumidores[i].start();
		}
		
		for(int i = 0; i < N; i++) {
			productores[i].join();
		}
		for(int i = 0; i < M; i++) {
			consumidores[i].join();
		}

		
		System.err.println("Acaba");
		
	}
	
	
}

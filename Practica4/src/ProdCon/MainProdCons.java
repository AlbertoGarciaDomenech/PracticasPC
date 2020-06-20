package ProdCon;

public class MainProdCons {
	
	public static void main(String[] args) throws InterruptedException {

		int N = 5;					 	// Num Productores
		int M = 10;						// Num Consumidores
		MonitorProdCon monitor = new MonitorProdCon();
		Dato dato = new Dato();
		Thread[] productores = new Thread[N];
		Thread[] consumidores = new Thread[M];
		
		for(int i = 0; i < N; i++) {
			productores[i] = new Productor(i,monitor,dato);
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

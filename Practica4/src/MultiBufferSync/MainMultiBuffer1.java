package MultiBufferSync;

public class MainMultiBuffer1 {
	
	public static void main(String[] args) throws InterruptedException {

		int N = 5;					 	// Num Productores
		int M = 10;						// Num Consumidores
		MonitorMultiBuffer1 monitor = new MonitorMultiBuffer1();
		DatoMultiBuffer1 dato = new DatoMultiBuffer1();
		
		Thread[] productores = new Thread[N];
		Thread[] consumidores = new Thread[M];
		
		for(int i = 0; i < N; i++) {
			productores[i] = new ProductorMultiBuffer1(i,monitor,dato,i + 1);
			productores[i].start();
		}
		for(int i = 0; i < M; i++) {
			consumidores[i] = new ConsumidorMultiBuffer1(i,monitor,i + 1);
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

package MultiBufferLockAndCondition;

public class MainMultiBuffer2 {
	
	public static void main(String[] args) throws InterruptedException {

		int N = 5;					 	// Num Productores
		int M = 10;						// Num Consumidores
		
		MonitorMultiBuffer2 monitor = new MonitorMultiBuffer2();
		DatoMultiBuffer2 dato = new DatoMultiBuffer2();
		
		Thread[] productores = new Thread[N];
		Thread[] consumidores = new Thread[M];
		
		for(int i = 0; i < N; i++) {
			productores[i] = new ProductorMultiBuffer2(i,monitor,dato,i + 1);
			productores[i].start();
		}
		for(int i = 0; i < M; i++) {
			consumidores[i] = new ConsumidorMultiBuffer2(i,monitor,i + 1);
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

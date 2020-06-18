import P3.Producto;

public class Buffer {
	
	private int N = 10; //numero de slots
	Producto[] buf = new Producto[N];
	private int front;	//primera posicion disponible para consumir
	private int rear;	//primera posicion vacia	((front + count) % N)
	private int count;	//numero de posiciones no vacias

	
}

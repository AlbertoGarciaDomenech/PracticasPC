package mensajes;

public abstract class Message {

	private int type;
	// 0 = CONEXION  1 = LISTA_USUARIOS  2 = CERRAR_CONEXION  3 = PEDIR_FICHERO 
	// 4 = PREPARADO 5 = CONFIRMACION CONEXION  6 = CONFIRMACION CERRAR CONEX
	// 7 = EMITIR FICHERO  
	private String origin;
	private String destiny;
	private String argument;
	
	public Message(int _type, String _origin, String _destiny, String _arg) {
		this.type = _type;
		this.origin = _origin;
		this.destiny = _destiny;
		this.argument = _arg;
	}
	
	public int getType() {
		return type;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public String getArgument() {
		return this.argument;
	}
	
}

package mensajes;

public abstract class Message {

	
	// 0 = CONEXION  1 = LISTA_USUARIOS  2 = CERRAR_CONEXION  3 = PEDIR_FICHERO 
	// 4 = PREPARADO 5 = CONFIRMACION CONEXION  6 = CONFIRMACION CERRAR CONEX
	// 7 = EMITIR FICHERO  
	private messageType type;
	private String origin;
	private String destiny;
	private Object argument;
	
	public Message(messageType _type, String _origin, String _destiny, Object _arg) {
		this.type = _type;
		this.origin = _origin;
		this.destiny = _destiny;
		this.argument = _arg;
	}
	
	public messageType getType() {
		return type;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public Object getArgument() {
		return this.argument;
	}
	
}

package mensajes;

public abstract class Message {

	private int type; // 0 = CONEXION  1 = LISTA_USUARIOS  2 = CERRAR_CONEXION  3 = PEDIR_FICHERO  4 = PREPARADO 5 = CONFIRMACION
	private String origin;
	private String destiny;
	
	
	public Message(int _type, String _origin, String _destiny) {
		this.type = _type;
		this.origin = _origin;
		this.destiny = _destiny;
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
	
	public abstract String getUserID();
	
}

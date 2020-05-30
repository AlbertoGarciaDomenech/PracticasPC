package mensajes;

public class MensajeConexion  extends Message{

	
	public MensajeConexion(String _origin, String _destiny) {
		super(messageType.CONEXION, _origin, _destiny, null);
	}	

}

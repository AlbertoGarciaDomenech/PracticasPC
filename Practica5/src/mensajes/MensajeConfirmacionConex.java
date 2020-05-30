package mensajes;

public class MensajeConfirmacionConex extends Message {

	public MensajeConfirmacionConex(String _origin, String _destiny) {
		super(messageType.CONFIRMACION_CONEXION, _origin, _destiny,null);
	}

}

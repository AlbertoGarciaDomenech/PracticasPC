package mensajes;

public class MensajeConfirmacionAdd extends Message {

	public MensajeConfirmacionAdd(String _origin, String _destiny) {
		super(messageType.CONFIRMACION_ADD, _origin, _destiny);
	}

}

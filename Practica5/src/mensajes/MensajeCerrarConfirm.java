package mensajes;

public class MensajeCerrarConfirm extends Message{

	public MensajeCerrarConfirm(String _origin, String _destiny) {
		super(messageType.CONFIRMACION_CERRAR, _origin, _destiny);
	}

}

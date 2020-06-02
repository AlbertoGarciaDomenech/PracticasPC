package mensajes;

public class MensajeCerrarConex extends Message{

	public MensajeCerrarConex(String _origin, String _destiny) {
		super(messageType.CERRAR_CONEXION, _origin, _destiny);
	}

}

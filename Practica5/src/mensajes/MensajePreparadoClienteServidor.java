package mensajes;

public class MensajePreparadoClienteServidor extends Message {

	public MensajePreparadoClienteServidor(String _origin, String _destiny, Object _arg) {
		super(messageType.PREPARADO_CLIENTE_SERVIDOR, _origin, _destiny, _arg);
	}

}

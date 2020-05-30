package mensajes;

public class MensajePreparadoServidorCliente extends Message {

	public MensajePreparadoServidorCliente(String _origin, String _destiny, Object _arg) {
		super(messageType.PREPARADO_SERVIDOR_CLIENTE, _origin, _destiny, _arg);
		}

}

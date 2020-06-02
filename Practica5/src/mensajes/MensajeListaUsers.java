package mensajes;

public class MensajeListaUsers extends Message{

	
	public MensajeListaUsers(String _origin, String _destiny) {
		super(messageType.LISTA_USUARIOS, _origin, _destiny);
	}

}

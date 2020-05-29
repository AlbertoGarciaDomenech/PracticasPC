package mensajes;

public class MensajeListaUsers extends Message{

	
	public MensajeListaUsers(String _origin, String _destiny,String _listaUsers) {
		super(1, _origin, _destiny,_listaUsers);
	}

}

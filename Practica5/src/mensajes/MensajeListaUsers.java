package mensajes;

public class MensajeListaUsers extends Message{

	private String listaUsers;
	
	public MensajeListaUsers(int _type, String _origin, String _destiny,String _listaUsers) {
		super(1, _origin, _destiny);
		this.listaUsers = _listaUsers;
	}

}

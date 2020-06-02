package mensajes;

public class MensajeConfirmacionLista extends Message {

	private String listaUsers;
	
	public MensajeConfirmacionLista(String _origin, String _destiny, String _lista) {
		super(messageType.CONFIRMACION_LISTA, _origin, _destiny);
		this.listaUsers = _lista;
	}

	public String getLista() {
		return this.listaUsers;
	}
	
}

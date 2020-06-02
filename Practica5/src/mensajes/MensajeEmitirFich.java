package mensajes;

import serv.Usuario;

public class MensajeEmitirFich extends Message {

	private Usuario userAmandar;
	private String fileEmitir;
	
	public MensajeEmitirFich(String _origin, String _destiny, Usuario _user, String _file) {
		super(messageType.EMITIR_FICHERO, _origin, _destiny);
		this.userAmandar = _user;
		this.fileEmitir = _file;
	}
	
	public Usuario getUser() {
		return this.userAmandar;
	}
	
	public String getFileName() {
		return this.fileEmitir;
	}

}

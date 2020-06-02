package mensajes;

import serv.Usuario;

public class MensajeConexion  extends Message{

	private Usuario newUser;
	public MensajeConexion(String _origin, String _destiny, Usuario _newUser) {
		super(messageType.CONEXION, _origin, _destiny);
		this.newUser = _newUser;
	}	

	public Usuario getNewUser() {
		return this.newUser;
	}
	
}

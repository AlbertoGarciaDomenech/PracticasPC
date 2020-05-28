package mensajes;

public class MensajeConexion  extends Message{

	private String userID;
	
	public MensajeConexion(int _type, String _origin, String _destiny, String _userID) {
		super(0, _origin, _destiny);
		this.userID = _userID;
		// TODO Auto-generated constructor stub
	}	

}

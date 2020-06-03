package mensajes;

import java.net.InetAddress;

public class MensajePreparadoClienteServidor extends Message {

	private int port;
	private InetAddress dirIP;
	private String userAmandar;
	private String fileAmandar;	
	
	public MensajePreparadoClienteServidor(String _origin, String _destiny,String _user, InetAddress _dirIP, int _port, String _f) {
		super(messageType.PREPARADO_CLIENTE_SERVIDOR, _origin, _destiny);
		this.dirIP = _dirIP;
		this.port = _port;
		this.userAmandar  =_user;
		this.fileAmandar = _f;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public InetAddress getIP() {
		return this.dirIP;
	}

	public String getC1() {
		return this.userAmandar;
	}
	
	public String getF() {
		return this.fileAmandar;
	}
}

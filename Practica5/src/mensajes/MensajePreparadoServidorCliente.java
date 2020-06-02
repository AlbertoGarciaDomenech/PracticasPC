package mensajes;

import java.net.InetAddress;

public class MensajePreparadoServidorCliente extends Message {
	
	private InetAddress dirIp;
	private int port;
	
	public MensajePreparadoServidorCliente(String _origin, String _destiny, InetAddress _dirIp, int _port) {
		super(messageType.PREPARADO_SERVIDOR_CLIENTE, _origin, _destiny);
		this.dirIp = _dirIp;
		this.port = _port;
		}
	
	public InetAddress gertIP() {
		return this.dirIp;
	}
	public int getPort() {
		return this.port;
	}
}

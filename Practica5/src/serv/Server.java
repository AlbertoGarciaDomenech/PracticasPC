package serv;
import java.io.*;
import java.net.*;

public class Server {

	private InetAddress dirIP;
	private int port;
	private MonitorSockets sockets;			//monitor que guarda nombre de usuario y los InputsStream y OutputStream de un cliente
	private MonitorData data;				//monitor que guarda nombre de usuario y una instancia de Usuario(nombre,dir ip y lista de informacion compartida)
	
	public Server(InetAddress _ip, int _p) {
		this.dirIP = _ip;
		this.port = _p;
		this.sockets = new MonitorSockets();
		this.data = new MonitorData();
		
	}

	public static void main(String[] args) throws UnknownHostException {
		
		if(args.length < 1) return;
		InetAddress _dirIP = InetAddress.getLocalHost();
		int _port = Integer.parseInt(args[0]);
		
		Server server = new Server(_dirIP,_port);
		
		try(ServerSocket serverSocket = new ServerSocket(server.getPort())){
			
			while(true) {
				Socket socket =  serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				(new OyenteCliente(socket, in, out, server.getSockets(), server.getData())).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getPort() {
		return this.port;
	}
	public InetAddress getIP() {
		return this.dirIP;
	}
	
	public MonitorSockets getSockets() {
		return this.sockets;
	}
	public MonitorData getData() {
		return this.data;
	}

}

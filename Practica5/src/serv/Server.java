package serv;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	//private MONITOR usuarios (tripleta idUsuario, canal comunicacion input, canal comunicacion output)
	
	static HashMap<String,Object[]> usersInfo;
	static HashMap<String, Object[]> usersData;
	static MonitorSockets sockets;
	static MonitorData data;
	
	static InetAddress dirIP;
	static int port;
	
	public static void main(String[] args) throws UnknownHostException {
		
		if(args.length < 1) return;
		dirIP = InetAddress.getLocalHost();
		port = Integer.parseInt(args[0]);
		//Server server = new Server(ip,port);
	
		sockets = new MonitorSockets();
		
		data = new MonitorData();
		
		
		try(ServerSocket serverSocket = new ServerSocket(port)){
			
			while(true) {
				Socket socket =  serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				(new OyenteCliente(socket, in, out, sockets, data)).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

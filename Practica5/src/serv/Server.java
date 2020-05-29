package serv;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	//private MONITOR usuarios (tripleta idUsuario, canal comunicacion input, canal comunicacion output)
	
	static HashMap<String,Object[]> usersInfo;
	static HashMap<String, Object[]> usersData;
	static MonitorUsers info;
	static MonitorData data;
	
	static InetAddress dirIP;
	static int port;
	
	public static void main(String[] args) throws UnknownHostException {
		
		if(args.length < 1) return;
		dirIP = InetAddress.getLocalHost();
		port = Integer.parseInt(args[0]);
		//Server server = new Server(ip,port);
	
		
		try(ServerSocket serverSocket = new ServerSocket(port)){
			
			while(true) {
				Socket socket =  serverSocket.accept();
				

				(new OyenteCliente(socket, info, data)).start();
				
//				InputStream inputS = socket.getInputStream(); 
//				OutputStream outputS = socket.getOutputStream();
				
//				PrintWriter wr = new PrintWriter(outputS, true);
//				wr.println("User-Agent: Simple Http Client");
													
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

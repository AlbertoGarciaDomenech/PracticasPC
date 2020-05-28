package serv;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	//private tabla usuarios (tripleta idUsuario, canal comunicacion input, canal comunicacion output)
	private InetAddress dirIP;
	private int port;
	
	public Server(InetAddress ip, int port) {
		this.dirIP = ip;
		this.port = port;
		
		
		//init userTable(id,fin,fout) and info(id,list<>)
	}
	
	
	
	public static void main(String[] args) throws UnknownHostException {
		
		if(args.length < 1) return;
		InetAddress ip = InetAddress.getLocalHost();
		int port = Integer.parseInt(args[0]);
		Server server = new Server(ip,port);
	
		
		try(ServerSocket serverSocket = new ServerSocket(port)){
			
			while(true) {
				Socket socket =  serverSocket.accept();
				
				(new OyenteCliente(socket)).start();
				InputStream inputS = socket.getInputStream(); 
				OutputStream outputS = socket.getOutputStream();
				
				PrintWriter wr = new PrintWriter(outputS, true);
				wr.println("User-Agent: Simple Http Client");
													
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

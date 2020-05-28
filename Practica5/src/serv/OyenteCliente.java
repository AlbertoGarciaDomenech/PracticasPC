package serv;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Map;

public class OyenteCliente extends Thread{

	
	//Monitor que comunica cliente y servidor
	
	private volatile  Map<String, ArrayList<String>> info;
	
	private ServerSocket socket;
	private volatile InputStream fin;
	private volatile OutputStream fout;
	
	
	public OyenteCliente(ServerSocket s) {
		this.socket = s;
	}
	
	public void run() {
		
	}
	
	
	
}


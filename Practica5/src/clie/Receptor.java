package clie;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import mensajes.MensajeCerrarConex;
import mensajes.MensajeConexion;
import mensajes.MensajeListaUsers;
import mensajes.MensajePedirFIch;

public class Receptor extends Thread{

	private InetAddress dirIP;
	private int port;
	
	
	public Receptor(InetAddress _dirIP, int _port) {
		this.dirIP = _dirIP;
		this.port = _port;
		
	}
	public void run() {
		try(Socket socket = new Socket(this.dirIP,this.port)) { 	// crea el socket con el emisor
			ObjectInputStream inputChannel = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

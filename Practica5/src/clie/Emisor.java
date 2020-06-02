package clie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import serv.OyenteCliente;

public class Emisor extends Thread{

	
	private ServerSocket serverSocket;
	private Object infoEmitir;
	
	public Emisor(String _infoEmitir) throws IOException {
		this.serverSocket = new ServerSocket(0);		//ponemos el puerto 0 para que se nos asigne automaticamente uno libre
		this.infoEmitir = _infoEmitir;
	}
	
	public int getPort() {
		return serverSocket.getLocalPort();
	}
	
	public void run() {
		Socket socket;
		try {
			socket = serverSocket.accept();
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(this.infoEmitir);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

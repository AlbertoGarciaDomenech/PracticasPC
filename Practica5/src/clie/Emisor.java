package clie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Emisor extends Thread{

	
	private ServerSocket serverSocket;
	private String infoEmitir;
	private FileInputStream inFile;
	
	
	public Emisor(String _infoEmitir) throws IOException,FileNotFoundException {
		this.serverSocket = new ServerSocket(0);		//ponemos el puerto 0 para que se nos asigne automaticamente uno libre
		this.infoEmitir = _infoEmitir;
		this.inFile = new FileInputStream(this.infoEmitir);
	}
	
	public int getPort() {
		return serverSocket.getLocalPort();
	}
	
	public void run() {
		Socket socket;
		try {
			socket = serverSocket.accept();		//esperamos en accept a que se conecte el receptor
			inFile.transferTo(socket.getOutputStream());

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

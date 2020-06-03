package clie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Receptor extends Thread{

	private InetAddress dirIP;
	private int port;
	private String fileName;
	private FileOutputStream fileDesc;
	
	public Receptor(InetAddress _dirIP, int _port, String _filename) throws FileNotFoundException {
		this.dirIP = _dirIP;
		this.port = _port;
		this.fileName = _filename;
		this.fileDesc = new FileOutputStream(this.fileName);
	}
	public void run() {
		try(Socket socket = new Socket(this.dirIP,this.port)) { 	// crea el socket con el emisor
			System.err.println("Descargando " + fileName);
			socket.getInputStream().transferTo(fileDesc);
			System.err.println("Descarga finalizada de " + this.fileName);
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

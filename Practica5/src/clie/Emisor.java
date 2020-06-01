package clie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import serv.OyenteCliente;

public class Emisor extends Thread{

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	private Object infoEmitir;
	private int port;
	
	public Emisor(ObjectInputStream _in, ObjectOutputStream _out, Object _info, int _port) {
		this.inputChannel = _in;
		this.outputChannel = _out;
		this.infoEmitir = _info;
		this.port = _port;
	}
	
	public void run() {
	try(ServerSocket serverSocket = new ServerSocket(port)){
		Socket socket =  serverSocket.accept();
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(this.infoEmitir);
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
}


package clie;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import mensajes.MensajeCerrarConex;
import mensajes.MensajeConexion;
import mensajes.MensajeListaUsers;
import mensajes.MensajePedirFIch;

public class Receptor extends Thread{

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	
	
	public Receptor(ObjectInputStream _in, ObjectOutputStream _out) {
		this.inputChannel = _in;
		this.outputChannel = _out;
		
	}

	try(Socket socket = new Socket(dirIp,port)) { 	// crea el socket con el emisor
		ObjectInputStream inputChannel = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}

package serv;
import java.io.*;
import java.net.*;

import mensajes.*;


public class OyenteCliente implements Runnable{

	
	//Monitor que comunica cliente y servidor
	
	
	private Socket socket;
	private volatile ObjectInputStream fin;
	private volatile ObjectOutputStream fout;
	private MonitorUsers info;
	
	public OyenteCliente(Socket s, MonitorUsers monInfo) throws IOException {
		this.socket = s;
		this.fin = new ObjectInputStream (s.getInputStream());
		this.fout = new ObjectOutputStream (s.getOutputStream());
		this.info = monInfo;
		
	}
	
	public void run() {
		//info.add(userID, in, out);
		
		while(true) {
			
			Message message = null;
			try {
				message = (Message) fin.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			switch(message.getType()) {
				case 0:
					//NUEVA CONEXION
					info.add(message.getOrigin(), this.fin, this.fout);
					fout.writeObject(new MensajeConfirmacionConex(5, message.getDestiny(), message.getOrigin()));
					break;
					
				case 1:
					//PASAR LISTA USUARIOS
					String response = info.getUsersList();
					
					break;
					
				case 2:
					//CERRAR CONEXION
					info.delete(message.getOrigin());
					fout.writeObject(new MensajeCerrarConfirm(6, message.getDestiny(), message.getOrigin()));
					
					break;
					
//				case "ASK_FILE":
//					
//					break;
//					
//				case "READY":
//					
//					break;
//			
			}
					
		}
		
	}
	
	
	
}


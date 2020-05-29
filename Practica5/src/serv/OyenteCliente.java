package serv;
import java.io.*;
import java.net.*;

import mensajes.*;


public class OyenteCliente extends Thread{//implements Runnable{

	
	//Monitor que comunica cliente y servidor
	
	
	private Socket socket;
	private volatile ObjectInputStream fin;
	private volatile ObjectOutputStream fout;
	private MonitorUsers info;
	private MonitorData data;
	
	public OyenteCliente(Socket _s, MonitorUsers monInfo, MonitorData Mondata) throws IOException {
		this.socket = _s;
		this.fin = new ObjectInputStream (_s.getInputStream());
		this.fout = new ObjectOutputStream (_s.getOutputStream());
		this.info = monInfo;
		this.data =  Mondata;
	}
	
	public void run() {
		
		while(true) {
			
			Message message = null;
			try {
				message = (Message) fin.readObject();
			switch(message.getType()) {
				case 0:
					//NUEVA CONEXION
					info.add(message.getOrigin(), this.fin, this.fout);
					fout.writeObject(new MensajeConfirmacionConex(message.getDestiny(), message.getOrigin()));
					break;
					
				case 1:
					//PASAR LISTA USUARIOS
					String response = info.getUsersList();
					fout.writeObject(new MensajeListaUsers(message.getDestiny(), message.getOrigin(), response));
					break;
					
				case 2:
					//CERRAR CONEXION
					info.delete(message.getOrigin());
					
					fout.writeObject(new MensajeCerrarConfirm(message.getDestiny(), message.getOrigin()));
					
					break;
					
				case 3:
				//PEDIR FICHERO:
					String owner = data.getOwner(message.getArgument());
					fout.writeObject(new MensajeEmitirFich(message.getOrigin(), message.getDestiny()));
					break;
//					
//				case "READY":
//					
//					break;
//			
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
	}
}


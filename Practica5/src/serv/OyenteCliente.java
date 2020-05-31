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
	
	public OyenteCliente(Socket _s, ObjectInputStream _in,ObjectOutputStream _out, MonitorUsers monInfo, MonitorData Mondata) throws IOException {
		this.socket = _s;
		this.fout = _out; //new ObjectOutputStream (_s.getOutputStream());
		this.fin = _in; //new ObjectInputStream (_s.getInputStream());
		this.info = monInfo;
		this.data =  Mondata;
	}
	
	public void run() {
		
		while(true) {
//			Scanner scan = new Scanner(System.in);
//			scan.next();
			Message message = null;
			try {
				message = (Message) fin.readObject();
			switch(message.getType()) {
				case CONEXION:
					info.add(message.getOrigin(), this.fin, this.fout);
					fout.writeObject(new MensajeConfirmacionConex(message.getDestiny(), message.getOrigin()));
					break;
				case LISTA_USUARIOS:
					String response = info.getUsersList();
					fout.writeObject(new MensajeConfirmacionLista(message.getDestiny(), message.getOrigin(), response));
					break;
				case CERRAR_CONEXION:
					info.delete(message.getOrigin());
					fout.writeObject(new MensajeCerrarConfirm(message.getDestiny(), message.getOrigin()));
					break;
				case PEDIR_FICHERO:
					String owner = data.getOwner(message.getArgument().toString());
					//obtener fout2 de owners
					ObjectOutputStream fout2 = info.getFout(owner);
					fout2.writeObject(new MensajeEmitirFich(message.getOrigin(), message.getDestiny()));
					break;				
				case PREPARADO_CLIENTE_SERVIDOR:
					
					break;
			
				default:
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		
	}
}


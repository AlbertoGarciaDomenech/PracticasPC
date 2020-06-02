package serv;
import java.io.*;
import java.net.*;

import mensajes.*;


public class OyenteCliente extends Thread{

	
	//Monitor que comunica cliente y servidor
	
	
	private Socket socket;
	private volatile ObjectInputStream fin;
	private volatile ObjectOutputStream fout;
	private MonitorSockets sockets;
	private MonitorData data;
	
	public OyenteCliente(Socket _s, ObjectInputStream _in,ObjectOutputStream _out, MonitorSockets _sockets, MonitorData Mondata) throws IOException {
		this.socket = _s;
		this.fout = _out; //new ObjectOutputStream (_s.getOutputStream());
		this.fin = _in; //new ObjectInputStream (_s.getInputStream());
		this.sockets = _sockets;
		this.data =  Mondata;
	}
	
	public void run() {
		
		while(true) {
			Message message = null;
			try {
				message = (Message) fin.readObject();
			switch(message.getType()) {
				case CONEXION:
					MensajeConexion mConex = (MensajeConexion) message;
					String _userID = mConex.getNewUser().getUserID();
					sockets.add(_userID, this.fin, this.fout);
					data.add(_userID, mConex.getNewUser());
					fout.writeObject(new MensajeConfirmacionConex(message.getDestiny(), message.getOrigin()));
					break;
				case LISTA_USUARIOS:
					String response = sockets.getUsersList();
					fout.writeObject(new MensajeConfirmacionLista(message.getDestiny(), message.getOrigin(), response));
					break;
				case CERRAR_CONEXION:
					sockets.delete(message.getOrigin());
					fout.writeObject(new MensajeCerrarConfirm(message.getDestiny(), message.getOrigin()));
					socket.close();
					break;
				case PEDIR_FICHERO:
					MensajePedirFIch mPedir = (MensajePedirFIch) message;
					String fileName = mPedir.getFilename();
					String owner = data.getOwner(fileName);
					//obtener fout2 de owners
					ObjectOutputStream fout2 = sockets.getFout(owner);
					//obtenemos usuario propietario
					Usuario _user = data.getUser(owner);
					fout2.writeObject(new MensajeEmitirFich(message.getOrigin(), message.getDestiny(),_user, fileName));
					break;				
				case PREPARADO_CLIENTE_SERVIDOR:
					MensajePreparadoClienteServidor mPrep = (MensajePreparadoClienteServidor) message;
					//buscar fout1 (cliente al que mandar informacion)
					ObjectOutputStream fout1 = sockets.getFout(mPrep.getC1());
					InetAddress ipEmisor = mPrep.getIP();
					int port = mPrep.getPort();
					fout1.writeObject(new MensajePreparadoServidorCliente(message.getDestiny(), message.getOrigin(), ipEmisor, port));
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


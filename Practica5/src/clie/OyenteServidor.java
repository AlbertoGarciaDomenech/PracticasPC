package clie;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import mensajes.*;

public class OyenteServidor extends Thread {

	private Socket socket;
	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	private InputCliente interf;
	private int port;
	
	public OyenteServidor(Socket _s,ObjectInputStream _in, ObjectOutputStream _out, InputCliente _interf,int _port) {
		this.socket = _s;
		this.inputChannel = _in;
		this.outputChannel = _out;
		this.interf = _interf;
		this.port = _port;
	}
	
	public void run() {
		
		while(true) {
			
			Message m = null;
			
			try {
				m = (Message)inputChannel.readObject();
				
				messageType t = m.getType();
				
				switch(t) {
				
				case CONFIRMACION_CONEXION:
					interf.confConex();
					break;
					
				case CONFIRMACION_LISTA:
					MensajeConfirmacionLista mLis = (MensajeConfirmacionLista) m;
					interf.confLista(mLis.getLista());
					break;
				
				case EMITIR_FICHERO:
					MensajeEmitirFich mFich = (MensajeEmitirFich) m;
					
					String clienteC1 = mFich.getUser().getUserID();
					String infoEmitir = mFich.getFileName();
					//Crear Emisor y esperar en accept el socket
					Emisor emisor = (new Emisor(infoEmitir));
					int portEmisor = emisor.getPort();
					emisor.start();
					InetAddress ipEmisor = InetAddress.getLocalHost();
					outputChannel.writeObject(new MensajePreparadoClienteServidor(m.getDestiny(), m.getOrigin(),clienteC1, ipEmisor,portEmisor));
					break;
				
				case PREPARADO_SERVIDOR_CLIENTE:
					MensajePreparadoServidorCliente mPrep = (MensajePreparadoServidorCliente) m;
					int _port = mPrep.getPort();
					InetAddress ip = mPrep.gertIP();
					(new Receptor(ip,port)).start();
					
					break;
				
				case CONFIRMACION_CERRAR: 
					interf.cerrConex();
					socket.close();
					break;
				
				default:
					break;
				}
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}

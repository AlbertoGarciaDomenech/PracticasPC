package clie;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import mensajes.*;

public class OyenteServidor extends Thread {

	private Socket socket;
	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	
	public OyenteServidor(Socket _s,ObjectInputStream _in, ObjectOutputStream _out) {
		this.socket = _s;
		this.inputChannel = _in;
		this.outputChannel = _out;
	}
	
	public void run() {
		
		while(true) {
			
			Message m = null;
			
			try {
				m = (Message)inputChannel.readObject();
				
				messageType t = m.getType();
				
				switch(t) {
				
				case CONFIRMACION_CONEXION:
					System.err.println(("*Conexion establecida*"));
					break;
					
				case CONFIRMACION_LISTA:
					MensajeConfirmacionLista mLis = (MensajeConfirmacionLista) m;
					System.err.println(mLis.getLista()); 
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
					outputChannel.writeObject(new MensajePreparadoClienteServidor(m.getDestiny(), m.getOrigin(),clienteC1, ipEmisor,portEmisor, infoEmitir));
					break;
				
				case PREPARADO_SERVIDOR_CLIENTE:
					MensajePreparadoServidorCliente mPrep = (MensajePreparadoServidorCliente) m;
					int _port = mPrep.getPort();
					InetAddress ip = mPrep.gertIP();
					String fileDescar = mPrep.getFilename();
					(new Receptor(ip,_port,fileDescar)).start();
					
					break;
				
				case CONFIRMACION_CERRAR: 
					System.err.println("Adios!");
//					socket.close();
					break;
					
				case CONFIRMACION_ADD:
					System.err.println("*Archivo incorporado*");
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

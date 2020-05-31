package clie;

import java.io.*;

import mensajes.*;

public class OyenteServidor extends Thread {

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	private InputCliente interf;
	private int port;
	
	public OyenteServidor(ObjectInputStream _in, ObjectOutputStream _out, InputCliente _interf,int _port) {
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
					interf.confLista(m.getArgument().toString());
					break;
				case EMITIR_FICHERO:
					Object infoEmitir = m.getArgument();
					String clienteC1 = m.getArgument().toString();
					outputChannel.writeObject(new MensajePreparadoClienteServidor(m.getDestiny(), clienteC1, infoEmitir));
					//NO MANDA NULL, MANDA LA INFORMACION PEDIDA EN m.getArgument()
					//Crear Emisor y esperar en accept el socket
					(new Emisor(this.inputChannel,this.outputChannel,infoEmitir,port)).start();
					break;
				case PREPARADO_CLIENTE_SERVIDOR:
					
					break;
				case CONFIRMACION_CERRAR: 
					interf.cerrConex();
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

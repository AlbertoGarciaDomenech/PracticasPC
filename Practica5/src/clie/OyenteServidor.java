package clie;

import java.io.*;

import mensajes.*;

public class OyenteServidor extends Thread {

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	private InputCliente interf;
	
	public OyenteServidor(ObjectInputStream _in, ObjectOutputStream _out, InputCliente _interf) {
		this.inputChannel = _in;
		this.outputChannel = _out;
		this.interf = _interf;
	}
	
	public void run() {
		
		while(true) {
			
			try {
				Message m = (Message)inputChannel.readObject();
				
				messageType t = m.getType();
				
				switch(t) {
				
				case CONFIRMACION_CONEXION:
					
					System.out.println(("Conexion establecida"));
					break;
				case CONFIRMACION_LISTA:
				
					System.out.println(m.getArgument().toString()); //Mostrar por pantalla la lista recibida
					break;
				case EMITIR_FICHERO:
					
					break;
				case PREPARADO_CLIENTE_SERVIDOR:
					
					break;
				case CONFIRMACION_CERRAR: 
					System.out.println("Adios!");
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

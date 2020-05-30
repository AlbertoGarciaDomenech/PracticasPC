package clie;

import java.awt.TrayIcon.MessageType;
import java.io.*;
import java.net.*;
import java.util.*;

import mensajes.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException {
		
		//CREACION DE VARIABLES
		int port; 							//indica el puerto por el que se va a comunicar con el servidor
		InetAddress localhost, dirIP; 		//localhost indica la direccion ip del servidor, mientras que dirIP indica la del cliente
		String hostname, userID;
		InputCliente interf = new InputCliente();
		
		//INICIALIZACION DE VARIABLES
		dirIP =  InetAddress.getLocalHost(); 		//para probar inicializamos tanto la dirIp del cliente como la del servidor como la direccion local
		localhost = InetAddress.getLocalHost();
		if(args.length < 1) return;
		if(args.length == 1) {
			port = Integer.parseInt(args[0]);
			hostname = localhost.toString();
		}
		else {
			hostname = args[0];
			port = Integer.parseInt(args[1]);
						
		}
		
		userID = interf.askUserID();
		try(Socket socket = new Socket(localhost,port)) { 	// crea el socket con el servidor
			ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inputChannel = new ObjectInputStream(socket.getInputStream());
				
			(new OyenteServidor(inputChannel, outputChannel,interf)).start();	// crea un nuevo thread con el OyenteServidor
			outputChannel.writeObject(new MensajeConexion(userID, hostname)); 	// enviar mensaje conexion al servidor(se recibe confirmacion en OyenteServidor)
				
			//establecer menu con usuario en interfaz
			int opcion = interf.menu();
			
			while(opcion != 0) {
				switch (opcion) {					
					case 1:
						//CONSULTAR LISTA DE TODOS LOS USUARIOS	
						outputChannel.writeObject((new MensajeListaUsers(userID, hostname, null)));
						break;
					case 2:
						//PEDIR FICHERO
						
						break;
				}
				opcion = interf.menu();
			}
				outputChannel.writeObject(new MensajeCerrarConex(userID, hostname));			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}

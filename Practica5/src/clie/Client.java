package clie;

import java.io.*;
import java.net.*;
import java.util.*;

import mensajes.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException {
		
		//CREACION DE VARIABLES
		
		int port; //indica el puerto por el que se va a comunicar con el servidor
		InetAddress localhost, dirIP; //localhost indica la direccion ip del servidor, mientras que dirIP indica la dirIP del cliente
		char c;
		Scanner scan = new Scanner(System.in);
		String hostname, userID;
		boolean more = true;
		
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
		System.out.println("¿Cual es tu nombre de usuario? :");
		userID = scan.nextLine();
		while(more) {
			try(Socket socket = new Socket(localhost,port)) { 
				ObjectInputStream inputChannel = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
				//conexion con el servidor
				//mandamos un mensaje de nueva conexion  y esperamos a recibir la confirmacion
				outputChannel.writeObject(new MensajeConexion(userID, hostname));
				Message m = (Message) inputChannel.readObject();
				if(m.getType() == 5){ // Comprobamos que el mensaje recibido por parte del servidor es del tipo MensajeConfirmacionConex
					//preguntar al cliente que quiere hacer
					
					System.out.println("Que quieres hacer: \n 1: Conocer el nombre de todos los usuarios en el servidor \n 2: Descargar informacion 0: Salir");
					switch(scan.nextInt()) {
						
						case 1: 
							//mandar mensaje al servidor pidiendo lista
							
					
					}
				}
				
			}
			catch(Exception e) {
				
			}
			finally {
				System.out.println("more?(y/n): ");
				c = scan.next().toCharArray()[0];
				more = (c == 'y') ? true : false;
			}

		}
	}
}

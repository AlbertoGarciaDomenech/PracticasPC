package clie;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import mensajes.*;
import serv.Usuario;

public class Client {
	
	private InetAddress localhost, dirIP; 								
	private String hostname, userID;
	private Scanner scan;
	private Usuario _user;												
	
	public Client(InetAddress _host, InetAddress _ip, String _hname, String _uID, Usuario _u) {
		this.localhost = _host;
		this.dirIP = _ip;
		this.hostname = _hname;
		this.userID = _uID;
		this._user = _u;
		this.scan = new Scanner(System.in);
	}

	public static void main(String[] args) throws UnknownHostException {
		
		//CREACION DE VARIABLES
		Scanner scan = new Scanner(System.in);
		int port; 								//indica el puerto por el que se va a comunicar con el servidor	
		InetAddress localhost, dirIP; 			//localhost indica la direccion ip del servidor, mientras que dirIP indica la del cliente					
		String hostname, userID;
		Usuario _user;							//usuario con id,dirIp,lista de informacion compartida					
		ArrayList<String> infoCompartida = new ArrayList<>();		
		
		//INICIALIZACION DE VARIABLES
		dirIP =  InetAddress.getLocalHost(); 						//para probar inicializamos tanto la dirIp del cliente como la del servidor como la direccion local
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
		
		System.out.println("�Cual es tu nombre de usuario? :");
		userID = scan.nextLine();
		
		infoCompartida = askInfo(scan);
		_user = new Usuario(userID, dirIP, infoCompartida);
		
		Client client = new Client(localhost, dirIP, hostname, userID, _user);
		
		try(Socket socket = new Socket(client.getHost(),port)) { 	// crea el socket con el servidor
			ObjectInputStream inputChannel = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outputChannel = new ObjectOutputStream(socket.getOutputStream());
			(new OyenteServidor(socket,inputChannel, outputChannel,port)).start();	// crea un nuevo thread con el OyenteServidor
			
			outputChannel.writeObject(new MensajeConexion(userID, hostname, _user)); 	// enviar mensaje conexion al servidor(se recibe confirmacion en OyenteServidor)

				
			//establecer menu con usuario
			int opcion = client.menu(scan);
			
			while(opcion != 0) {
				switch (opcion) {					
					case 1:
						//CONSULTAR LISTA DE TODOS LOS USUARIOS	
						outputChannel.writeObject((new MensajeListaUsers(userID, hostname)));
						break;
					case 2:
						//PEDIR FICHERO
						System.out.println("�Que fichero quieres? :");
						String fileName = scan.next();//Line();
						outputChannel.writeObject((new MensajePedirFIch(userID, hostname, fileName)));
						break;
				}
				opcion = client.menu(scan);
			}
				outputChannel.writeObject(new MensajeCerrarConex(userID, hostname));			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public InetAddress getHost() {
		return this.localhost;
	}
	
	public Usuario getUser() {
		return this._user;
	}
	
	public int menu(Scanner scan) {
		int opcion;
		System.out.println("Que quieres hacer: \n 1: Conocer el nombre de todos los usuarios en el servidor \n 2: Descargar informacion \n 0: Salir");
		opcion = scan.nextInt();
		while(opcion < 0 || opcion > 2) { //Asegurar que la opcion escrita por el cliente sea posible
			System.out.println("Opcion no valida, por favor elija una de las tres opciones.\n");
			System.out.println("Que quieres hacer: \n 1: Conocer el nombre de todos los usuarios en el servidor \n 2: Descargar informacion \n 0: Salir");
			opcion = scan.nextInt();
				
		}
		return opcion;		
	}

	
	public static ArrayList<String> askInfo(Scanner scan) {
		ArrayList<String> strList = new ArrayList<>();
		String more;
		System.out.println("�Posees algun archivo?(y/n) ");
		more = scan.next();
		while((more.equals("y"))) {
			System.out.println("\n�Que archivos posees?(introduce uno a uno): ");
			strList.add(scan.next());
			System.out.println("\n�Posees algun archivo mas?(y/n) ");
			more = scan.next();
		}		
		return strList;
	}
}

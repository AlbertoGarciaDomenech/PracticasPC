package clie;

import java.util.*;

import mensajes.messageType;

public class InputCliente {

	
	private String userID;
	private Scanner scan;
	
	public InputCliente() {
		
		scan = new Scanner(System.in);
		
	}
	
	public String askUserID() {
		
		System.out.println("¿Cual es tu nombre de usuario? :");
		
		userID = scan.nextLine();
	
		return userID;
	}
	
	public void confConex() {
		System.out.println(("Conexion establecida"));
	}
	
	public void confLista(String l) {
		System.out.println(l); //Mostrar por pantalla la lista recibida
	}
	
	public void cerrConex() {
		System.out.println("Adios!");
	}
	
	public int menu() {
		int opcion;
		System.out.println("Que quieres hacer: \n 1: Conocer el nombre de todos los usuarios en el servidor \n 2: Descargar informacion 0: Salir");
		opcion = scan.nextInt();
		while(opcion < 0 || opcion > 2) { //Asegurar que la opcion escrita por el cliente sea posible
			System.out.println("Opcion no valida, por favor elija una de las tres opciones.\n");
			System.out.println("Que quieres hacer: \n 1: Conocer el nombre de todos los usuarios en el servidor \n 2: Descargar informacion 0: Salir");
			opcion = scan.nextInt();
				
		}
		return opcion;		
	}
	
}

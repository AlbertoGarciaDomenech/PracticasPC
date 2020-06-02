package clie;

import java.util.*;


public class InputCliente {

	
	private String userID;
	private Scanner scan;
	
	public InputCliente() {
		
		scan = new Scanner(System.in);
		
	}
	
	public String askUserID() {
		
		System.out.println("�Cual es tu nombre de usuario? :");
		
		userID = scan.nextLine();
	
		return userID;
	}
	
	public void confConex() {
		System.out.println(("*Conexion establecida*"));
	}
	
	public void confLista(String l) {
		System.out.println(l); //Mostrar por pantalla la lista recibida
	}
	
	public void cerrConex() {
		System.out.println("Adios!");
	}
	
	public int menu() {
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

	public String askFile() {
		
		System.out.println("�Que fichero quieres? :");
		
		userID = scan.nextLine();
	
		return userID;
	}

	public ArrayList<String> askInfo() {
		ArrayList<String> str = new ArrayList<>();
		String more;
		System.out.println("�Posees algun archivo?(y/n) ");
		more = scan.next();
		while((more.equals("y"))) {
			System.out.println("\n�Que archivos posees?(introduce uno a uno): ");
			str.add(scan.next());
			System.out.println("\n�Posees algun archivo mas?(y/n) ");
			more = scan.next();
		}		
		return str;
	}
	
}

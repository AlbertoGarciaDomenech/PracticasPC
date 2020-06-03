package clie;

import java.util.*;


public class InputCliente {

	
	private String str;
	private Scanner scan;
	
	public InputCliente() {
		
		scan = new Scanner(System.in);
		
	}
	
	public String askUserID() {
		
		System.out.println("¿Cual es tu nombre de usuario? :");
		
		str = scan.nextLine();
	
		return str;
	}
	
	public void confConex() {
		System.err.println(("*Conexion establecida*"));
	}
	
	public void confLista(String l) {
		System.err.println(l); 
	}
	
	public void cerrConex() {
		System.err.println("Adios!");
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
		
		System.out.println("¿Que fichero quieres? :");
		
		str = scan.nextLine();
	
		return str;
	}

	public ArrayList<String> askInfo() {
		ArrayList<String> strList = new ArrayList<>();
		String more;
		System.out.println("¿Posees algun archivo?(y/n) ");
		more = scan.next();
		while((more.equals("y"))) {
			System.out.println("\n¿Que archivos posees?(introduce uno a uno): ");
			strList.add(scan.next());
			System.out.println("\n¿Posees algun archivo mas?(y/n) ");
			more = scan.next();
		}		
		return strList;
	}
	
}

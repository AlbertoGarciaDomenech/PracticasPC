package clie;

import java.util.*;

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
	
	
}

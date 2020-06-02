package serv;

import java.io.*;
import java.util.*;



public class MonitorSockets {

	private volatile Hashtable<String,Object[]> data;
	
	public MonitorSockets() {
		this.data = new Hashtable<String,Object[]>();
		
	}
	
	synchronized void add(String userID, ObjectInputStream in, ObjectOutputStream out) {
		if(!data.containsKey(userID)) {		//check if user already in database
			Object[] p = {in,out};
			this.data.put(userID,p); 
		}
			
	}
	
	synchronized ObjectOutputStream getFout(String _userID) {
		if(data.containsKey(_userID)) {	
			//el valor del diccionario es un array de objetos donde la pos 0 es el inputStream y la pos 1 el outputStream
			ObjectOutputStream fout = (ObjectOutputStream) data.get(_userID)[1];
			return fout;
		}
		return null;
	}
	
	
	synchronized void delete(String userID) {
		if(data.contains(userID)) {
			this.data.remove(userID);
		}
	}
	
}

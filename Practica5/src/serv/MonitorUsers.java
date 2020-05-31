package serv;

import java.io.*;
import java.util.*;



public class MonitorUsers {

	private volatile Hashtable<String,Object[]> data;
	
	public MonitorUsers() {
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
			ObjectOutputStream fout = (ObjectOutputStream) data.get(_userID)[1];
			return fout;
		}
		return null;
	}
	
	synchronized String getUsersList() {
		Enumeration<String> enu = this.data.keys();
		
		StringBuilder str = new StringBuilder();
		while (enu.hasMoreElements()){
			str.append(enu.nextElement());
		}
		return str.toString();
	}
	
	synchronized void delete(String userID) {
		if(data.contains(userID)) {
			this.data.remove(userID);
		}
	}
	
}

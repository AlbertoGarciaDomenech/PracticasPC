package serv;

import java.util.*;

public class MonitorData {

	private volatile HashMap<String, Usuario> data;
	
	public MonitorData() {
		
		this.data = new HashMap<String, Usuario>();
	}
	
	
	synchronized public void add(String _userID, Usuario user) {
		
		if(!data.containsKey(_userID)) { //checks if user already in database
			data.put(_userID, user);
		}
	}
	
	synchronized public void delete(String _userID) {
		if(data.containsKey(_userID))
			data.remove(_userID);
	}

	synchronized String getOwner(String file) {
		
		for(String key : data.keySet()) {  			//recorremos todas las claves del diccionario
			if(data.get(key).hasFile(file)) {		//comprobamos si la clase usuario tiene file
				return key;	
			}
		}
		return null;
	}
	
	synchronized Usuario getUser(String id) {
		return data.get(id);
	}


	synchronized String getUsersList() {
		
		StringBuilder str = new StringBuilder();
		str.append("Lista de usuarios:\n ");
		for(String key : data.keySet()) {
			str.append(key);
			str.append("[");
			str.append(data.get(key).getList());
			str.append("]\n");
		}
		//str.delete(str.length()-2, str.length());
		str.append('.');
		return str.toString();
	}
	
	
}

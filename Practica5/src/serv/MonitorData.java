package serv;

import java.util.*;

public class MonitorData {

	private volatile HashMap<String, String[]> data;
	
	public MonitorData() {
		
		this.data = new HashMap<String, String[]>();
	}
	
	
	synchronized public void add(String _userID, String[] _files) {
		
		if(!data.containsKey(_userID)) { //checks if user already in database
			data.put(_userID, _files);
		}
	}
	
	synchronized public void delete(String _userID) {
		if(data.containsKey(_userID))
			data.remove(_userID);
	}
	
	synchronized String getOwner(String file) {
		StringBuilder owners = new StringBuilder(); //String con todos los userIDs que poseen file
		
		for(String k : data.keySet()) {  //recorremos todas las claves del diccionario
			boolean owner = false;
				for(String s : data.get(k)) //recorremos el array de string de cada clave
					if(s.equals(file))owner = true;
			if(owner)owners.append(k);
		}

		return owners.toString();
	}
	
	
}

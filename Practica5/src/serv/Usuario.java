package serv;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.*;

public class Usuario implements Serializable {

	private String userID;												//nombre
	private InetAddress dirIp;											//direccion Ip
	private ArrayList<String> info =  new ArrayList<String>();			//lista de informacion compartida
	
	public Usuario(String _userID, InetAddress _dirIP, ArrayList<String>  _info) {
		this.userID = _userID;
		this.dirIp = _dirIP;
		this.info = _info;
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public InetAddress getIP() {
		return this.dirIp;
	}
	
	public String[] getList() {
		return (String[]) this.info.toArray();
	}
	
	public void addtoList(String newFile) {
		
	}
	
	public boolean hasFile(String filename) {
		return info.contains(filename);
	}
}

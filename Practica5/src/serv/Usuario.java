package serv;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.*;

public class Usuario implements Serializable {

	private String userID;												//nombre
	private InetAddress dirIp;											//direccion Ip
	private ArrayList<String> info =  new ArrayList<String>();			//lista de informacion compartida(no tiene por que ser igual a la informacion que tiene el usuario)
	
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
	
	public String getList() {
		StringBuilder sb = new StringBuilder();
		for(String str : info) {
			sb.append(str);
			sb.append("|");
		}
		return sb.toString();
	}
	
	public void addtoList(String newFile) {
		this.info.add(newFile);
	}
	
	public boolean hasFile(String filename) {
		return info.contains(filename);
	}
}

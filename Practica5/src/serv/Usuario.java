package serv;

import java.net.InetAddress;
import java.util.*;

public class Usuario {

	private String userID;
	private InetAddress dirIp;
	private Object[] info;
	
	public Usuario(String _userID, InetAddress _dirIP, Object[]  _info) {
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
	
	public Object[] getList() {
		return this.info;
	}
	
	public void addtoList(Object o) {
		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(this.info));
		temp.add(o);
		info = temp.toArray();
	}
}

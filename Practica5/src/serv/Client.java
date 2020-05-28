package serv;

import java.io.ObjectInputStream;
import java.util.Hashtable;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String,Object[]> data = new Hashtable<String,Object[]>();
		ObjectInputStream in = null;
		Object[] p = {in};
		data.put("uno", p);
		System.out.println(data.toString());

		
	}

}

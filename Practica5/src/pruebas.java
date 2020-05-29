import java.util.HashMap;


public class pruebas {

	public static String checkOwner(HashMap<String,String[]> h, String b) {
		
		StringBuilder owners = new StringBuilder();
		
		for(String k : h.keySet()) {
			
			boolean owner = false;
				for(String s : h.get(k))
					if(s.equals(b))owner = true;
			if(owner)owners.append(k);
		}

		return owners.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		HashMap<String, String[]> a = new HashMap<>();
		String[] str = {"file1", "file2", "file3"};
				
		for(int i = 0; i < 5 ; i++)
			a.put(Integer.toString(i),str);
		String[] c = {"file67", "2"};
		a.put("7s", c);
	
		StringBuilder bui = new StringBuilder();
		for(String s : a.keySet()) {
			bui.append(s);
			bui.append(":");
			bui.append(a.get(s).toString());
		}
		
//		System.out.println(bui.toString());
//		System.out.println(a.toString());
		System.out.println(checkOwner(a,"file67"));*/
		
		System.out.println("Que quieres hacer: \n a");

	}

}

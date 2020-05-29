package mensajes;

public class MensajePedirFIch extends Message{
	
	public MensajePedirFIch(String _origin, String _destiny,String _file) {
		super(3, _origin, _destiny, _file);
	}

}

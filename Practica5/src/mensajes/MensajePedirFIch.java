package mensajes;

public class MensajePedirFIch extends Message{
	
	public MensajePedirFIch(String _origin, String _destiny,String _file) {
		super(messageType.PEDIR_FICHERO, _origin, _destiny, _file);
	}

}

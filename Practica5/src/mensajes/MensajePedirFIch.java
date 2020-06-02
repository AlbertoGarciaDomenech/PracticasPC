package mensajes;

public class MensajePedirFIch extends Message{
	
	private String filename;
	public MensajePedirFIch(String _origin, String _destiny,String _file) {
		super(messageType.PEDIR_FICHERO, _origin, _destiny);
		this.filename = _file;
	}
	
	public String getFilename() {
		return this.filename;
	}

}

package mensajes;

public class MensajeAdd extends Message{

	private String file;
	
	public MensajeAdd(String _origin, String _destiny, String _fileAdded) {
		super(messageType.ADD_FILE, _origin, _destiny);
		this.file = _fileAdded;
	}

	public String getfile() {
		return this.file;
	}
	
}

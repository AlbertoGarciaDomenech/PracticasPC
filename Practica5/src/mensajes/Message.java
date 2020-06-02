package mensajes;

import java.io.Serializable;

public abstract class Message implements Serializable{

	private messageType type;
	private String origin;
	private String destiny;
	
	public Message(messageType _type, String _origin, String _destiny) { 
		this.type = _type;
		this.origin = _origin;
		this.destiny = _destiny;
	}
	
	public messageType getType() {
		return type;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	
}

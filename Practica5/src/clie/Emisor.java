package clie;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Emisor {

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	private Object infoEmitir;
	
	public Emisor(ObjectInputStream _in, ObjectOutputStream _out, Object _info) {
		this.inputChannel = _in;
		this.outputChannel = _out;
		this.infoEmitir = _info;
	}
	
	
	
	
}

package clie;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Emisor {

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	
	
	public Emisor(ObjectInputStream _in, ObjectOutputStream _out) {
		this.inputChannel = _in;
		this.outputChannel = _out;
	}
	
}
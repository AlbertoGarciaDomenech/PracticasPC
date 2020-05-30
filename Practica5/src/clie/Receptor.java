package clie;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Receptor {

	private ObjectInputStream inputChannel;
	private ObjectOutputStream outputChannel;
	
	
	public Receptor(ObjectInputStream _in, ObjectOutputStream _out) {
		this.inputChannel = _in;
		this.outputChannel = _out;
		
	}

	
	
}

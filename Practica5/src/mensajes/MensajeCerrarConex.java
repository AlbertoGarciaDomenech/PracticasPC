package mensajes;

public class MensajeCerrarConex extends Message{

	public MensajeCerrarConex(int _type, String _origin, String _destiny) {
		super(2, _origin, _destiny);
	}

}

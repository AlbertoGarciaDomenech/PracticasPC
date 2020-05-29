package mensajes;

public class MensajeCerrarConex extends Message{

	public MensajeCerrarConex(String _origin, String _destiny) {
		super(2, _origin, _destiny, null);
	}

}

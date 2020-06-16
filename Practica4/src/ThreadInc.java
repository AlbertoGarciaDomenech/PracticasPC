
public class ThreadInc extends Thread {

	
	private Monitor m;
	
	public ThreadInc(Monitor _mon) {
		this.m = _mon;
	}
	
	public void run() {
		for(int i = 0; i < 1; i++) {
			this.m.incrNum();
		}
	}
	
}

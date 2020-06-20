package IncrDecr;

public class ThreadDec extends Thread {

	
	private Monitor m;
	
	public ThreadDec(Monitor _mon) {
		this.m = _mon;
	}
	
	public void run() {
		for(int i = 0; i < 1; i++) {
			this.m.decrNum();
		}
	}
	
}

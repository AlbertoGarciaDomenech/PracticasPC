package IncrDecr;

public class Monitor {

	
	private int num;
	
	public Monitor() {
		num = 0;
	}
	
	
	synchronized void incrNum() {
		this.num++;
	}
	
	synchronized void decrNum() {
		this.num--;
	}
	
	synchronized int getNum() {
		return this.num;
	}
	
}

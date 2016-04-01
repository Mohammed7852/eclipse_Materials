package Assignment_3_Semaphor;
	
	public class SynchronizedCounter {
	private int c = 0;
	public synchronized void increment() {
	int register = c;
	register = register+1;
	c = register;
	}
	public   void decrement() {
	int register = c;
	register = register-1;
	c = register;
	}
	public synchronized int value() {
	return new Integer(c);
	}
	}
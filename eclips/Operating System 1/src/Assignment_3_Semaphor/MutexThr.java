package Assignment_3_Semaphor;

public class MutexThr {
	
public static void main(String[] args) {
	
SynchronizedCounter count = new
SynchronizedCounter();
MyThread thrA = new MyThread("A", count);
MyThread thrB = new MyThread("B", count);

thrA.start();
thrB.start();
try {
thrA.join();
thrB.join();
} catch (InterruptedException e) {
System.out.println("Join interrupted");
}
}
}
package Assignment_3_Semaphor;

public class MyThread extends Thread {
private SynchronizedCounter sc;
private String myName;
public MyThread(String name, SynchronizedCounter sc) {
this.sc = sc;
this.myName = name;
}
public void run() {
sc.decrement();
System.out.println("C = " + new Integer(sc.value()) + " inThread " + myName);
}
}
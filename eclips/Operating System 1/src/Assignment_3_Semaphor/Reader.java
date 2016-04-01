package Assignment_3_Semaphor;

public class Reader extends Thread {

	String name  ="";
	int counter=0;
	Reader_Writer rw ;
	
	public Reader(String  n  , Reader_Writer rw){
		this.name=n;
		this.rw=rw;
 	}
	
	public void run(){
	   System.out.println(name+"  start  Reading.");
		rw.read(name);

	}
	
	
}//class

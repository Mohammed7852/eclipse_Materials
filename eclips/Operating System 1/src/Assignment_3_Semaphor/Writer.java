package Assignment_3_Semaphor;

public class Writer extends Thread{

	Reader_Writer rw ;
	
	String  name ="" , word ="";
	
	public Writer(String n , String  word ,Reader_Writer rw){
		this.name=n;
		this.word=word;
		this.rw=rw;
 	}
	
	public void run(){
		System.out.println(name+"  start  Writing.");
		rw.write(name, word);
	}
	
}//class

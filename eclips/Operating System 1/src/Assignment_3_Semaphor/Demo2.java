package Assignment_3_Semaphor;
 
import java.util.*;

class  Demo2{
	
	static  Scanner  cin =new  Scanner(System.in);
 	static buffer  buf = new buffer();
	
	public static  void  main(String[]args){ 		
	 Thread  prod = new producer(buf);
	 Thread  cons = new consumer(buf);
	 
	 prod.start();
	 cons.start();
 	
	
	}//main
	
}//class
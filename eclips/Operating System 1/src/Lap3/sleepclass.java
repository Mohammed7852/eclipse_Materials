package Lap3;
import  java.util.*;


public class  sleepclass  implements  Runnable{
	private  String  name  ; 
	public sleepclass(String  n){
		name  = n ;
	}
	public void  Run(){
 		for(int  i=0 ;i<1000 ;i++){
		 System.out.print(name + "."+i);
		 Thread.yield();
		}
	}
	
	public  static void  main(String  []args) throws InterruptedException  {
		
		//Thread c1 = new Thread(new sleepclass("c1"));
		//Thread c2 = new Thread((java.lang.Runnable) new sleepclass("c1"));
		//c1.start();
		//c2.start();
		
		
		String  arr [] = {"a" , "b" , "c" , "d"  , "e" , "g" , "h" , "i" , "j"};
		
//		for(String  s  :arr){
// 			Thread.sleep(1000);
//			System.out.print(s+"\n");
//			}//end while
//		
		
		
//		int  h=0 , m=0 , s=0 ; 
//		
//		while(true){
//			Thread.sleep(1000);
//				s++;
//			System.out.println(h+":"+m+":"+s+"\n");
//			if(s==60){
//				m++;
//				s=0 ;
//			}
//			if(m==60){
//				h++ ;
//				m=0 ;
//			}
//		}
//		             
	
	}//main
}//class
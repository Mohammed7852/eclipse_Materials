
package Assignment2_threads;

public class counter extends Thread{
	
	private String str ;
	int  c=0  ;
	public counter(String s){
		this.str = s;
	}
	public void run(){
		for(int  i = 0 ;i<1000;++i){
			c++ ;
			System.out.println(str + " : "+i+"      c="+c);
			//Thread.yield();
		}
	}
	public static void  main(String []args){
		Thread c1 = new Thread(new counter("c1"));
		Thread c2 = new Thread(new counter("c2"));
		
		c1.start();
		c2.start();
		
		
	}
}


//
////public class HelloRunnable  implements Runnable{
//	public class HelloRunnable extends Thread{
//	
//	public void  run(){
// 		System.out.println("hello");
//		if(isAlive()){
//			
//		}
//		if(interrupted()){
//			
//		}
//		setPriority(MAX_PRIORITY);
//		
//		
//	}
// 
//	public static void  main(String[]argd){
//		 
//		//new Thread(new HelloRunnable()) .start(); ;
// 		(new HelloRunnable()).start();
//		
//		
//	}

//}

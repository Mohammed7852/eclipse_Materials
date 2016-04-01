package Assignment_3_Semaphor;
public class Semaphor {
	protected int  value  = 0 ;

	protected  Semaphor(){
		value=0;		
	}
	protected Semaphor(int  val){
		value=val;
	}
	
 	public synchronized void  P(String str , int x){
 		value--;
		if(value<0){
			try{
				  if(x==2)
				System.out.println(str+"  Blocked.");
				wait();
			}catch(Exception e){
 			}
		}
	}//
 	
	public synchronized void V(String str , int x){
 		value++;
		if(value<=0){
			try{
				//System.out.println(str+"  Notified.");
				notify();
			}catch(Exception e){
 			}
		}
	}
 	public synchronized  int getvalue(){
		return value;
	}
}//class 

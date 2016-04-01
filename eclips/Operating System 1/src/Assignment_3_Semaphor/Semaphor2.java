package Assignment_3_Semaphor;

public class Semaphor2 {

	protected int  value  = 0 ;
	
	protected  Semaphor2(){value=0;		
	}
	protected Semaphor2(int  val){value=val;
	}
	
	public synchronized void  P(int x){
		if(x==1){
			System.out.println("value--  by producer.\n");
		}else{
			System.out.println("value--  by Consumer.\n");
		}
		value--;
		if(value<0){
			try{
				wait();
			}catch(Exception e){
 			}
		}
	}//
	
	public synchronized void V(int x){
		if(x==1){
			System.out.println("value++  by producer.\n");
		}else{
			System.out.println("value++  by Consumer.\n");
		}
		
		value++;
		if(value<=0){
			try{
				notify();
			}catch(Exception e){
 			}
		}
	}
	
	public int getvalue(){
		return value;
	}
	
}//class 

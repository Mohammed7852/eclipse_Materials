package Assignment_3_Semaphor;

public class producer extends Thread{

	buffer buf ;
	
	public producer(buffer b){
		this.buf=b;
	}

	public void run(){
		for(int i=1;i<=50;i++){
			buf.producer(new Integer(i) , i);
		}
	}
	
}//class 

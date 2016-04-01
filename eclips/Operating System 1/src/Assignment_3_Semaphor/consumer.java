package Assignment_3_Semaphor;

public class consumer extends Thread {

	buffer  buf ;
	
	public consumer(buffer buf){
		this.buf=buf;
	}
	public void run(){
		for(int i=1;i<=50;i++){
			System.out.print("consumer "+(i)+"  :"+buf.consumer(i)+" " );
		}
	}
}

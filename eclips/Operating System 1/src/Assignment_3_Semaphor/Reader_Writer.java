package Assignment_3_Semaphor;

public class Reader_Writer {

	private static String text = "Hello!";
	private int counter = 0;	
	
	private static  Semaphor r =new Semaphor(1);
	private static  Semaphor w =new Semaphor(1);
	
	public void read(String  str ){
		 r.P(str , 1);
 		 counter++;
		if(counter==1)
			w.P(str, 2);
		r.V(str,1);
 		System.out.println(str+" reading :"+text+"");
		System.out.println(str+" Finished Reading ");
		r.P(str,1);	
 		counter--;
		if(counter==0)
			w.V(str,2);
 		r.V(str,1);
  	}//reader

	public void write(String str , String word){
 		//r.P();
		w.P(str,2);
		text+=word;
 		System.out.println(str+"  Writing :"+text);	
		System.out.println(str+" Finished Writing .");
		//r.V(str);
 		w.V(str,2);
	}//writer
	
	
}

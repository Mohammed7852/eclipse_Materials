package Assignment_3_Semaphor;

public class buffer {

	private  int  size= 5 ;
	int  in=0 , out =0;
	
	private Object store[] = new Object[size];
	
	Semaphor2 space  = new Semaphor2(size);//1
	Semaphor2 elements = new Semaphor2(0);//1
	
	public void producer(Object elem , int x){
 		System.out.println("producer "+x+"  starts.\n");
 		
 		if(space.getvalue()<=0){
			System.out.println("producer "+x+" blocked.\n");
		}
 		
   		space.P(1);
 		store[in]=elem;
		in=(in+1)%size;
		elements.V(1);
		
		System.out.println("producer "+x+" ends.\n");

	}//
	
	public Object consumer(int x){
		System.out.println("Consumer "+x+" starts.\n");
		if(elements.getvalue()<=0){
			System.out.println("Consumer "+x+" blocked.\n");
		}
  		elements.P(2);		 		
		Object temp = store[out];
		out= (out+1)%size;
		space.V(2);
		
		System.out.println("Consumer "+x+"  ends.\n");
		
 		return temp ;
	}//
	
	
	
}//class

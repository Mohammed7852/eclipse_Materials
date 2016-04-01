package LZ_77;
import java.util.*; 


public class Test_LZ_77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner cin = new Scanner(System.in); 
 		 
		 Compression c  =new Compression();
		 GUI g = new GUI();
		 
 		 
		 
		String  str  = "ABAABABAABBBBBBBBBBBBA" ; 
 		
	     //str = cin.nextLine();
 		// c.set_original(str);
 		// c.comprise();
 		 
		int  choice ;
		while(true)
		{
			
			System.out.print("\n\n\tWhat type of operation you want to do :\n"
					+ "1)compression.\n"
					+ "2)compression and Decompression.\n"
					+ "3)Decompression only.\n");
			
			choice = cin.nextInt() ;
			
			if(choice<0)break ;
			
			if(choice==1)
			{
				c = new Compression();
				System.out.println("\nEnter your String to be compreese :\n");
				 str =cin.next();
				 c.set_original(str);
		 		 c.comprise();
 			}
			else if(choice==2)
			{
				c = new Compression();
				System.out.println("\nEnter your String to be compreese :");
				str = cin.next();
				  c.set_original(str);
		 		  c.comprise();
		 		 c.Decompression();	
  		 		 
			}
			else if(choice==3)
			{
				c = new Compression();
				int sz  ;
				System.out.println("Enter the size  of your codes :");
				sz = cin.nextInt();
				c.setcodes(sz);
				 c.Decompression();	
 			}
			
			
		}//end while  loop 
//	
// 		  c.set_original(str);
// 		  c.comprise();
// 		 c.Decompression();	
		
		
	}//end  main 
 
}//end  class 

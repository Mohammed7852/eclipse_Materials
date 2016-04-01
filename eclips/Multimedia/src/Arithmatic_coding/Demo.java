package Arithmatic_coding;
import java.io.IOException;
import java.util.*;

public class Demo {
	public static void main(String[] args) throws IOException {
		Scanner  cin = new Scanner(System.in);
		
 		Compression c = new  Compression();
		Decompression dc = new  Decompression();
		
		int  choice=0 ;
		System.out.println("press  \n\t1)to compress.\n\t2)to Decompress.\n\t3)to break.");
		choice=cin.nextInt();
		
		while(choice>0){
			if(choice==1){
				c.compress();
			}else  if(choice==2){
				dc.decompress();
			}
			else if(choice==3){
				System.out.println("Thank you");
				break;
			}
			System.out.println("press  1)to compress.\n2)to Decompress.\n3)to break.");
			choice=cin.nextInt();
		}
		//

	}//main

}

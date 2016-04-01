package huffmand;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Demo {

	public static void main(String[] args) throws IOException
	{
		Scanner cin = new Scanner(System.in);
		hufmand  h  = new hufmand  ();
 		List<Character> list = new ArrayList<Character>();
 		Set<Character> set = new HashSet<Character>();
 		List<Double> L = new ArrayList();
  
 		String  str="" ; 
 		
 		int  choice = 5 ;
 		
 		System.out.println("press  \n1)to compress\n2)to Decompress.\nEnter your choice:");
 		choice = cin.nextInt();
 		while(choice>0)
 		{
 			h = new hufmand();
 			if(choice==1)
 			{
 				//System.out.println("Enter the String :");
 				//cin.nextLine();
 				//str = cin.nextLine();
 				Path  p = Paths.get("input.txt");
 				byte [] b = Files.readAllBytes(p);
 				str = new String(b);
 				
 				String str2 = h.Compress(str);
 		              
 				FileOutputStream w  = new FileOutputStream("output.txt");
  				//Integer x  =  Integer.parseInt(str2) ;
 				//System.out.println(x+"\n");
   				
				  w.write(str2.getBytes()); 				
 				  w.close();
				  
 			}
 			else if(choice==2)
 			{
 				System.out.println("Enter codes you want to decompress::");
 				String  codes ="";
 				cin.nextLine();
 				codes = cin.nextLine();
 				//System.out.println(ls+ "    "+lc+"\n\n");
 				h.deconmpress(codes );
 				
 			}
 			
 			System.out.println("press  \n1)to compress\n2)to Decompress.\nEnter your choice:");
 	 		choice = cin.nextInt();
 		}
 	 
	}//end main

}//end class

package Lap_implementation;

import java.awt.font.NumericShaper;
import  java.util.*;

public class ToDoApplication {
	private  static  Scanner  cin = new  Scanner (System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Mohammed  Ali");

		List<User> l = new ArrayList();
 		String  filename   , fileid  , filepage ;
		
 		
		 
 			           String  username  , usermail ;
			           
			           System.out.print("user name   :");;
			           cin.next() ;
			           username = cin.nextLine() ;
			           System.out.print("mail :");;
 			           usermail = cin.nextLine() ;
			            l.add(new User(username , usermail));
			          
 		 System.out.print("users :"+l+"\n");;
		
		
		
	}

}

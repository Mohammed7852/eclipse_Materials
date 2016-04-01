import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author mohamed ali shabanah
 *@category 
 *class test bank  tests  the bank operations  including  accounts  and  clients  
 *and  their  special cases
 */
public class test_bank 
{

	public static void main(String[] args) 
	{
 
		Scanner  cin = new  Scanner(System.in);
		
		Bank b= new Bank();
		Client c  = new Client() ;
		Account a = new Account();
		
		String  name , address  ;  int  id   ,phone , no ;  double balance ;
		
		int  choice = 1000 ; 
		

		 System.out.print(
			  "Press (1) to add  new  client.\n"+
	          "press (2) to display all clients.\n");
	
		 choice= cin.nextInt();
	
		 while(choice>0)
		 {
		
			 if(choice==1)
			 {
				 int type1 ,type2 ;
				 
				 
				 System.out.print("Client Name :");
				 cin.nextLine();//this  is  ti take the  first line which is   \n
				 name = cin.nextLine();
				 
				 System.out.print("Client  id  :");
				 id = cin.nextInt();
				 
				 System.out.print("Client address :");
				 cin.nextLine();
				 address = cin.nextLine();
				 
				 System.out.print("Client phone :");
				 phone  = cin.nextInt();
				 
				 System.out.print("       Client Account :\n");
					 System.out.print("Account number :");
					 no = cin.nextInt();
					 System.out.print("Account balance :");
					 balance = cin.nextDouble();
			
				 System.out.print("What type  of Account ? ::press  (1)  if  Normal  press "
				 		+ " (2)  if Special ::");
				 type2 = cin.nextInt();
				 
				 if(type2==1)
				 { 
					 a= new  Account(no , balance);			 
				 }
				 else if(type2==2)
				 {
					 a = new  Special_Account(no , balance);					 
				 }
				 else System.out.print("we can not  understand your pressing.\n");
				 

				 System.out.print("what type  of  Client?    press (1) if  Normal Client ..."
				 		+ "   press (2)  if  Commercial  Client :");
				 type1= cin.nextInt();
				 
			if(type1==1)
			{
			    c = new  Client(name ,address  , id  , phone , a);
			 }
			 else 
				 {
				    c = new  Commercial_Client(name ,address  , id  , phone , a);
				 }
 			
			b.setaccount(a);//to set account  in class account   to display all accounts 
			b.setclient(c);
		 
			 }else if  (choice == 2)
			 {
				 b.displayclients();
			 }
			 

			 System.out.print(
				"Press (1) to add  new  client.\n"+
		         "press (2) to display all clients.\n");
		
			 choice= cin.nextInt();
		
		 }//end  while 
		 
		 
		 
	}//end  main 

}//end  class test Bank 

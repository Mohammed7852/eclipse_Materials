import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner ;


/**
 * 
 * @author mohamed ali shabanah
 *class Demo 
 *test the  Nim Game  between Computer  and user 
 */

public class Demo 
{

	public static void main(String []args)
	{
		Scanner  cin = new  Scanner(System.in);
 
		Nim N =new  Nim();
		//the_100_NimGame  N = new the_100_NimGame();

 		int choice  ;
		System.out.print("\tWhat type  of  Game you would like to play :"
				+ "\n(1)NimGame  \n(2)The 100 NimGam :\n");
		choice = cin.nextInt();
		
		while(choice>0)
		{
			if(choice==1)
			{	
				 	N= new Nim();
				int  x  ,y  , z  ;
				
				System.out.print("Heap1:");
				x = cin.nextInt();
				System.out.print("Heap2:");
				y= cin.nextInt();
				System.out.print("Heap3:");
				z = cin.nextInt();
				
				N.setheaps( x , y , z  );
				N.play();
			}
			else if(choice==2)
			{
				N = new the_100_NimGame();
				N.play();
			}
			
			System.out.print("\tWhat type  of  Game you would like to play :"
					+ "\n(1)NimGame  \n(2)The 100 NimGam :\n");
			choice = cin.nextInt();
			
		}//end while
	}
}

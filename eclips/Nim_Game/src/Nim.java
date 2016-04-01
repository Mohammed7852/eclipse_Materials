import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

/**
 * class Nim  Game between 2 players 
 * @author mohamed ali shabanah
  */

public class Nim {
/**
 * 
 */
	private  int  player  ,type ,Heap[] = new  int  [3];
	private  int heap1 , heap2 , heap3  ,h1  , h2  ,h3 , c=0 ; 
	private  int  res1 ,res2 ,res3 , last ; 
	public static Scanner cin = new  Scanner(System.in);
	
	 /**
	  * default constructor  
	  */
	public Nim(){Heap=new int[3];}
	
	/**
	 * this  method assigns  first values of  Heaps 
 	 * @param x for  heap1
	 * @param y for heap2
	 * @param z for  heap3
	 */
	
	public void setheaps(int  x  ,int  y  , int  z)
	{
//		Heap[0]=x;
//		Heap[1]=y;
//		Heap[2]=z;
		
		this.heap1=x  ;
		this.heap2=y ;
		this.heap3=z ;
	}
	
	 
	/**
	 * 
	 * this  method return true  if the nim is (0) at the 
	 *  biggining of  game and return false  if  not  . 
	 * @return boolean temp  true  or  false  
	 */
	public boolean big_check()
	{
 		return ( heap1^heap2^heap3)==0;
 	}
	/**
	 * play function   :: is  a recursive function stopped only 
	 * when the  all heaps goes to 0.
	 * and will switch between  users
	 * 
 	 */
	public void play()
	{ 
       // i use  c only  as  flag  if the  nim_sum at first goes to 0 ,,
	  //so i request from user to start gaming 
		if(big_check()&&c==0)
		{
		       System.out.println("::"+heap1+"  "+heap2+"  "+heap3+"\n");
			   System.out.println("\tUser:\n");
			   User();
			   c=5;
		}
		else 
		{
 		    if(!check())
				{
 		    	System.out.println("finish\n");
	 			   return ;
				}
 			System.out.println("::"+heap1+"  "+heap2+"  "+heap3+"\n");
			System.out.println("\tComputer :");
		   Me();
 		   if(!check())
			{
				System.out.println("finish\n");
			   return ;
			}
	       System.out.println("::"+heap1+"  "+heap2+"  "+heap3+"");
		   System.out.println("\tUser:");
		   User();
		}
 	   play();
	}//end play 
	
	/**
	 * (check method) this  method  checks the  end of game  if the three  heaps  are  0s
	 * (last) 
	 * is a variable indicate  the user that finish the  problem 
	 * and  will be  the  winner 
	 *@return  boolean to indicate  finishing the  Game  

	 */
	public  boolean check()
	{
		boolean temp ;
		if((heap1==0&&heap2==0&&heap3==0))
			temp=false;
		else temp=true;
		if(!temp)
		{
 				if(last==1)
				{
					System.out.println("I  am the  Winner ^_^.\n");
				}
				else if(last==2)
				{
					System.out.println("The  user is  winner :') :D :P.\n");
				}
		}
		return temp ;
	}
	
	/**
	 * Me  method  :: is the computer method 
	 * that simulate the machine gaming to be always the winner
	 * 
	 */
	public void Me()
	{
		int  taked  , heap ;
		/**
		 * i keep track the heaps  before  modification 
		 */
		////////////////////////////////////
		h1 =heap1 ; h2=heap2  ; h3= heap3  ;
		if(heap1>=2)h1=heap1;
		else if(heap2>=2)h1=heap2;
		else if(heap3>=2)h1=heap3 ;
		///////////////////////////
	  if(check_2())
	  {
		 //res take the  XOR  between  heaps  
		int res =heap1^heap2^heap3 ;
		res1 = res^heap1 ;
		res2= res^heap2 ;
		res3= res^heap3; 
		//minimum res 
		int min =Math.min(res1 ,res2 );
		min = Math.min(min, res3);
		//we check if the minimum res is less than its heap or  not 
		boolean temp = check_min(min);
		if(!temp)
		{
			if(heap1>res1){heap1 =res1 ;}
			else if(heap2>res2)heap2 = res1 ;
			else if(heap3>res3)heap3 =res3 ; 
		}
		  //we check  the number of  1s  and  ... Are one of  heaps or more greater than 2 or not?? 
		 check_3();
	  }
	  else 
	  {
		//here  the current  heaps are all less than 2   
		  if(heap1>0)heap1--;
		  else if(heap2>0)heap2--;
		  else  if(heap3>0)heap3--;
	  }
 		//to indicate the last player 
		last=1;
	}//end  me 
	
	
	/**
 	 * check if  there exist heap or  more  greater than 2  
	 * and check if  number  of  1s is  even 
	 * 
 	 */
	public void check_3()
	{
        boolean temp ;
        //check greater than 2 or  not  
        temp =check_2();
		if(!temp)
		{
			//check number  of  1s even 
			boolean temp2 = is_even();
			if(!temp2)
				if(h1>=2)
			    {
					 while(!temp2 &&h1>0)
					 {
						 h1--;
						 heap1=h1;
						 heap2=h2;
						 heap3= h3 ;
						 temp2 = is_even();
					 }//
			 }
				else if(h2>=2)
			    {
					 while(!temp2 &&h2>0)
					 {
						 h2--;
						 heap1=h1;
						 heap2=h2;
						 heap3= h3 ;
						 
						 temp2 = is_even();
					 }//
			 }
				else if(h3>=2)
			 {
				 while(!temp2 &&h3>0)
				 {
					 h3--;
					 heap1=h1;
					 heap2=h2;
					 heap3= h3 ;
					 temp2 = is_even();
				 }//
			 }
		}
		
	}/////
	
	/***
	 *check if  summation of heaps  is  even 
	 * @return boolean  true if  the description above reached or  will return false 
	 */
	public boolean is_even()
	{
		boolean temp ;
		int  sum =heap1 + heap2  + heap3  ;
		return (sum%2)==0 ;
	}
	/**
	 * 
	 * @param min is  the  minimum  nim_sum   is less than its heap 
	 * @return boolean  true if  the description above reached or  will return false 
	 */
	public boolean check_min(int  min)
	{
		boolean temp  =false;
		if((min==res1)&&(res1<heap1)){heap1=res1 ;temp =true;}
		else if((min==res2)&&(res2<heap2)){heap2=res2;temp =true;}
		else if((min==res3)&&(res3<heap3)){heap3=res3 ;temp =true;}
		return temp ;
	}
	
	/**
	 * check if their exist at least  one heap  greater then 2 
	* @return boolean  true if  the description above reached or  will return false 
	 */
	public boolean check_2()
	{
		boolean  temp ;
		
		if((heap1>=2)||(heap2>=2)||(heap3>=2))
			temp =true;
		else temp = false  ;
		
		return (heap1>=2)||(heap2>=2)||(heap3>=2) ;
	}
	
	/**
	 * switched  method :: move  the  console  to user to play 
 	 */
	public void  User()
	{
		int  heap , value  ;
		System.out.print("Number  of  Heap:");
		heap = cin.nextInt();
		
		System.out.print("New Value:");
		value = cin.nextInt();
		
		if(heap==1)
		{
			heap1= value ;
			//Heap[0] = value  ;
		}
		else if(heap==2)
		{
			//Heap [1]= value ;
			heap2=value ;
		}
		else if(heap==3)
		{
			//Heap[2] = value  ;
			heap3 = value ;
		}
		
		//the last player  is  user 
		last = 2 ;
	}//end  user
}

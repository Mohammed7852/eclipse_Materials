import java.util.Scanner;

/**
 * 
 * @author mohamed ali shabanah
 *class operates the  100 nim Game  strategy 
 */

public class the_100_NimGame  extends Nim{
	
	private  static  int  num1 , num2 , num3 , sum  , temp , last  ;
	private Scanner cin = new Scanner(System.in);

/**
 * 
 * @param num1 is the computer number 
 * @param num2 is the  user chosen number 
 * @param num3
 * @param sum the  current summation 
 */
	
	/**
	 * default constructor initialize  variables 
	 * 
	 */
	the_100_NimGame()
	{
		sum = 0 ;
		num1 = 0 ;
		num2 = 0 ;
		temp = 0 ;
		last = 0 ;
	}
	
 
	/**
	 * recursive method 
	 * this method switches between players  
	 */
	public void  play()
	{
		//check 2  :: will check if the sum reaches to 100
			if(check_2())
				return ;
  			 Me();
 			if(check_2())
				return ;
  				User();
  				play();
 	}
	
	/**
	 * 
	 * @return boolean value  to indicate whether the sum goes to 100 or  not  
	 */
	public boolean check_2()
	{
		boolean temp = false  ;
		if(sum ==100)
			{
				temp =true ;
				if(last == 1)
					System.out.print("I am the  winner .\n");
				else System.out.print("User is the  Winner.\n");
			}
 			return temp ;
	}
	
	/**
	 * 
	 * @param num takes the number to be checked 
	 * @return boolean true if the digits are subsequent .
	 */
public boolean check( int num )
	{
		boolean tempo = false  ;
		
		int x = temp ; 
		int [] Arr = new  int[2] ;
		int i =0; 
		while(x>0)
		{
			int a =x%10 ;
			x = ( x - a )/ 10 ;
			Arr[i++]=a ; 
		}//
 		return (Arr[0]==(Arr[1]+1)) ;
	}
	
	public void Me()
	{
		System.out.print("\t\tMe :\n");
		temp = sum ;
		int  i = 1 ;
		
		if(100 - sum <=10)
		{
			System.out.print("I added "+(100-sum)+"  ,,,current  sum = "+sum+" \n");
				sum = 100 ;
 		}
		else 
		{		
				while(!(check(temp)) && (temp-sum<11))
				{
					//System.out.println("i = "+i + "   temp="+temp + "   (temp-sum)= " +(temp -sum )+ "    check = "+check(temp)+ "\n");
					i++;
					temp ++ ;
					//System.out.println("i = "+i + "   temp="+temp + "   (temp-sum)= " +(temp -sum )+ "    check = "+check(temp)+ "\n");
				}
 				int  t =sum ;
		 		if(i==11)  
				{
					sum =sum + 1; ;
				}
				else sum=temp ;
				t  = sum - t  ;
 				System.out.print("I added "+(t)+"  ,,,current  sum = "+sum+" \n");
	}
 		last = 1 ;
	}
	
	/**
	 * this method allows user to play
	 */
	public void User()
	{
		System.out.println("\n\n\t\tUser :\n");
		System.out.print("Enter your number : ");
		num2 = cin.nextInt();
		 
		while(!(num2>0&&num2<11))
		 {
			System.out.println("Invalid pressing!!!..press valid number : ");
			num2 = cin.nextInt();
		 }
			
		sum += num2 ;
		System.out.println("You Added : "+num2+" ,,Current Sum = "+sum+"\n");
		
		last = 2 ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	
	

}

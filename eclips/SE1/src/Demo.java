import java.util.ArrayList ;
import java.util.List ;
import java.util.*;
import java.util.Vector;
    

public class Demo 
{

	 
	public static void main(String[] args)
	{
 		
		Scanner cin = new Scanner(System.in) ;
		 
		List<Spanish_Meal>  list = new ArrayList();
		 Spanish_Meal m = new Spanish_Meal();
		  	 
              
		 int  choice ,  x ,y  ,z  ,b ,c  ,d ,c1=0 , c2 =0 , c3=0 ,  c4 = 0  , id    ,type ;
		 double a  ;
		 double  p1 =0, p2 =0 ,p3=0 , p4 =0  ,w1 =50 , w2=60  ,w3=200  ,w4=800  ;
		 String  name ;
		 
		 System.out.println("\t\tThis is  for stock::\nHow  many suppliers  ::");
		 x = cin.nextInt();
		 
		 for(int  i= 0 ;i <x  ;i++)
		 {
		 
			 System.out.println("Name  of  supplier<"+(i+1)+">::");cin.nextLine();name  = cin.nextLine();
			 System.out.println("Number  of  shipments  ::");y = cin.nextInt();
 
			 for(int  j= 0 ;j<y ;j++)
			 {
				 System.out.println("Shippment<"+(j+1)+">::");
				 System.out.println("Type  ::");type= cin.nextInt();
				 
				 if(type  == 1)
				 {
					 if(p1==0)
					 {
						 System.out.println("Enter the minimum price for this type :");p1 = cin.nextDouble();
					 }
					 
					 m = new open_natural_grassland(p1  , w1 , type , name );
					 c1++;
					 
				 }else  if(type ==2)
				 {
					 if(p2==0)
					 {
						 System.out.println("Enter the minimum price for this type :");p2 = cin.nextDouble();
					 }

					 m = new raised_and_fed_on_natural_food(p2  , w2 , type , name ); 
					 c2++;
				 }else  if(type  ==3)
				 {
					 if(p3==0)
					 {
						 System.out.println("Enter the minimum price for this type :");p3 = cin.nextDouble();
					 }

					 m = new fed_on_natural_and_manufactured_food(p3  , w3 , type , name ); 
					 c3++;
				 }else if(type  ==4)
				 {
					 if(p4==0)
					 {
						 System.out.println("Enter the minimum price for this type :");p4= cin.nextDouble();
					 }
                  
					 m = new fed_on_manfacured_feed(p4  , w4 , type , name ); 
					 c4++;
				 }else System.out.println("In valid pressing.\n");
				 
				 list.add(m);
				 
			 }//end  of  j for
			 
			 p1=p2=p3=p4=0;
			 
 		 }//end of  i for
		
		 System.out.print("الآن  بــداية  المزااد العلني \n"); 
		 
		 int sz = list.size();
		 System.out.println("Now  We Have  ("+sz+")  shippments,,,"+":");

		 int count = 0;
		 while(count<sz)
		 {
			 System.out.println(list.get(count++));
		 }//end  of while 
		 
		 System.out.println("Enter number  of customers  ::");
		 x  = cin .nextInt();
		 
 		 
		 /*************************/
		 customer []Array_Customer = new customer[x];
		 
		 System.out.println("plz ,, Specify shared money of  them ::");
		 y = cin.nextInt();
		 
		 /////////////////////////////
		 int   []array = new  int [x];
		 for(int i=0;i<x;i++)array[i]=y;
		 
		 ///////////////////////////////
		 int []Array = new  int [x];
		 int  []Array2 = new  int  [x];
		 
		 List [] Lis = new ArrayList[x];
		 
		 
		 /**
		  * no we  show  our  stoch to customers 
		  */
		 for(int i= 0 ;i<sz ; i++)
		 {
			 System.out.println("\tShippment no. <"+(i+1)+"> >>>\n");
			 System.out.println("Type of  Meal :"+list.get(i).gettype());
			 System.out.println("Supplier is  :"+list.get(i).getsupplier()+"\n"
			 		+ "Minimum price  is  :"+list.get(i).getprice()+"\n");
			 double  price = list.get(i).getprice();
			 type = list.get(i).gettype();
			 
			 
			 
			 /**
			  * i need  to check if  no  balance  and  show  message  
			  */
			 System.out.println("\tCustomer <1> ,, enter your price ::");
			 a = cin.nextInt();
			 
			 
			 if(array[0]<a)
				 System.out.println("You have no enought money.\n");
			 	
 			
			 double  mx = a  ;
			 int  index = 0 ;
			 
			 for(int j=1 ;j<x  ;j++)
			 {
				 System.out.println("\tCustomer : <"+(j+1)+"> ,, enter your price ::");
				 a  = cin.nextInt();
 
				 if(array[j]>=a)
				 {
 					 if(a>mx)
					 {
					 	mx=a;
					 	index = j ;
					 }
 					 
				 }else System.out.println("You have no enought money.\n");
			 	
			 }//end j for  
			 
			 //System.out.println("The choosed customer is  :("+(index+1)+")  and  max is  :("+mx+")\n");
			 		
			 			if(mx >= price )
						 {
 			 				System.out.println("Customer <"+(index+1)+">  gets the shippment ^_^..\n");
			 			    array[index]-=mx;
			 			    Array[index]++;
			 			  
			 			   if(type==1)Array2[index]+=4;
			 			   else  if(type==2)Array2[index]+=3;
			 			   else if(type==3)Array2[index]+=2;
			 			   else if(type==4)Array2[index]+=1;
			 			   
			 			   // Array_Customer[index].settype(type);
			 			   list.get(i).set_flag();
						 }else  System.out.println("oooh ,,,No one Buys this Shippoment...\n");
				
 			 		////////////////
			 		boolean temp = true ;//to check if  the all customers  have  no money 
			 		 for(int  j=0 ;j<x  ;j++)
			 		 {
			 			 if(array[j]>0){temp=false  ;break;}
			 		 }
			 		 if(temp)
			 		 {
			 			 System.out.print("no money for  all customers ...!!^_^\n");break;
			 		 }
			 		 	
			 		 System.out.println("Remain Money For each Customer is  ::"+"\n");
			 		 for(int n=0  ;n <x ;n++)System.out.print(array[n]+"   ");
			 			 
			 		System.out.println("\n\n");
		 }//end i for 
		 
		 
  		 Stack<Integer> check = new  Stack();
  		 /**
  		  * this  stack will include the indexes  of largest customers in buying
  		  */
  		 

  		 int mx = Array[0];
  		 check.push(0);
  		 
		 for(int  i= 1 ;i<x  ;i++)
		 {
			 if(Array[i]>mx)
				 {
				 	mx=Array[i];
				 	check.clear();
				 	check.push(i);
				 }else if(Array[i]==mx)
				 {
					 check.push(i);
				 }
		 }
		 System.out.print("\nCustomer  number  of  shippments ::");for(int  i=0 ;i<x  ;i++)System.out.print(Array[i]+"   ");
		 System.out.println("\nArray2 sum for  each customer ::");for(int  i=0 ;i<x  ;i++)System.out.print(Array2[i]+"   ");
 
		 System.out.println("\nmax number  of  shippments bought=     "+ mx + "   ,,, index of the  max number :"+(check)+" \n");
		 
		 Stack<Integer> st = new  Stack();

 
		 mx=Array2[0];
		 st.push(0);
		 
		 while(!check.empty())
		 {
			 int  index  = check.pop();
			 
			 if(Array2[index]>mx)
			 {
				 mx=Array2[index];
				 st.clear();
				 st.push(index);
			 }
			 else if(Array2[index]==mx)
			 {
				 st.push(index);
			 }
				 
				 
		 }//end while
		 
		 System.out.println("The  Winner  is  the  customer  number::\n("+st.pop()+"");
		
		 while(!st.empty())
		 {
			 System.out.print("  ,"+(st.pop()+1));
		 }
		 
		 System.out.print(")");
		 
		 
		 
		 
		 
		 
		  		 
		 
		 
	
 	}//end main
 

}//end  class Demo

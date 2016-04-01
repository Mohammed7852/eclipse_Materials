
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.portable.ApplicationException;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *@author  Shimaa Abdelkader 
  */
public class ApplianceStore 
{
        
/**
 * list of  Appliances
 */
 ArrayList  <Appliance> ListApps=new ArrayList<>();  
 
 
 /**
  * Selling  method  allows  supplier  to  sell what he  want  from appliance  
   */
 public void sell()
 {
    System.out.println("choose Appliance  form this list that u want to sell::\n "
    		+ "1-Refrigerator \n "
    		+ "2-Stove \n "
    		+ "3-WashingMachine \n ");
   
  Scanner cin =new Scanner(System.in);
  
   int choice =cin.nextInt();
   
   
   switch (choice)
   {
       case 1:
           System.out.print("your  choice is Refrigerator::\n");
           for (int i=0;i<ListApps.size();i++)
           {
               if(ListApps.get(i).getClass().getName().equals("Refrigerator"))
                   ListApps.remove(i);
               else if(i==ListApps.size()-1) 
                   System.err.println("there is not Refrigerator");
           }
           break;
       case 2:
           System.out.print("your  choice is Stove\n");
           for (int i=0;i<ListApps.size();i++)
           {
               if(ListApps.get(i).getClass().getName().equals("Stove"))
                   ListApps.remove(i);
               else if(i==ListApps.size()-1) 
                   System.err.println("there is not Stove");
           }
           break;
       case 3:
          System.out.print("your  choice is WashingMachine\n");
           for (int i=0;i<ListApps.size();i++)
           {
               if(ListApps.get(i).getClass().getName().equals("WashingMachine"))
                   ListApps.remove(i);
               else if(i==ListApps.size()-1) 
                   System.err.println("there is not WashingMachine");
           }
           break;
       default:
            System.err.println("this is fail choice");
           break;
   }
   }

  /**
   * method  of adding  new  appliance to list of  appliances  
   * 
   */
 public void add()
  {
      System.out.print("choose from this list:\n "
      		+ "1-Refrigerator.\n "
      		+ "2-Stove. \n "
      		+ "3-WashingMachine.\n");
      
      int high;
      String color , mode , make  , type;
      double price,warranty;
      
      
   
      Scanner cin =new Scanner (System.in);
      int choice=cin.nextInt();
     
      switch(choice)
      {
          case 1:
              
              System.out.print("please fill this instruction for Refrigerator:\n");
              System.out.print("please enter model for this Refrigerator:\n");
              mode=cin.next();
              System.out.print("please enter make for this Refrigerator:\n");
              make=cin.next();
              System.out.print("please enter high for this Refrigerator:\n");
              high=cin.nextInt();
              System.out.print("please enter price for this Refrigerator:\n");
              price=cin.nextDouble();
              System.out.print("please enter warranty for this Refrigerator:\n");
              warranty=cin.nextDouble();
              Refrigerator Ref=new Refrigerator( high,  make,  mode,  price,  warranty);
             
              ListApps.add(Ref);
              
              break;
          case 2:
               System.out.print("please fill this instruction for Stove:\n");
              System.out.print("please enter mode for this Stove:\n");
              mode=cin.next();
              System.out.print("please enter make for this Stove:\n");
              make=cin.next();
              System.out.print("please enter color for this Stove:\n");
              color=cin.next();
              System.out.print("please enter price for this Stove:\n");
              price=cin.nextDouble();
              System.out.print("please enter warranty for this Stove:\n");
              warranty=cin.nextDouble();
              Stove St=new Stove(color,  make,  mode,  price,  warranty);
             
              ListApps.add(St);
              
              break;
          case 3:
              System.out.print("please fill this instruction for WashingMachine:\n");
              System.out.print("please enter mode for this WashingMachine:\n");
              mode=cin.next();
              System.out.print("please enter make for this WashingMachine:\n");
              make=cin.next();
              System.out.print("please enter type for this WashingMachine:\n");
              type=cin.next();
              System.out.print("please enter price for this WashingMachine:\n");
              price=cin.nextDouble();
              System.out.print("please enter warranty for this WashingMachine:\n");
              warranty=cin.nextDouble();
                 WashingMachine Wash=new WashingMachine(type,  make,  mode,  price,  warranty);
             
                 ListApps.add(Wash);
                 
              break;
          default:
              break;
              
      }
      
  }
 /**
  * view method displayes  what u have  from appliances 
   */
 
 public void view()
 {
      
      for (Appliance ap : ListApps) 
      {
			System.out.println(ap.getClass().getName() + "  " + ap.toString());
	}
 }//end  view
 
    /**
     * Min method 
     * @param  args
      */
  public static  void  main (String []args)
  { 
      ApplianceStore App=new ApplianceStore();
      
      while(true)
      {
    	  
      System.out.println("choose operations from this list \n "
      		+ "1- Add. \n "
      		+ "2-Sell. \n "
      		+ "3-View. \n");
      
      Scanner cin =new Scanner (System.in);
      
        int choice=cin.nextInt();
       
        switch(choice)
        {
            case 1:
                App.add();
                break;
            case 2:
                App.sell();
                break;
            case 3:
                App.view();
                break;
            default :
                System.out.print("fail choice");
                break;
         }//end switch 
        
        }//end  while 
    }
    
}

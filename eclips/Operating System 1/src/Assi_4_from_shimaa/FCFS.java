/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assi_4_from_shimaa;

import java.util.*;

/**
 *
 * @author shimaa
 */
public class FCFS {
    
    Vector<Process> FIFO_Process = new Vector<Process>();
    
    public void SetFIFO_Process ( Vector<Process> vec){
        FIFO_Process = vec ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void Execution_Order (){
        
        System.out.println("FIFO Processes Execution Order");
    for(int i=0 ;i<FIFO_Process.size() ; i++)
        {
         System.out.print(FIFO_Process.elementAt(i).name + " ==> ");
        
        }
        System.out.println();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void Response_Time (){
      int res_time=0 ;
      int finish_time=0;
      int sum_res_time =0;
    
       System.out.println(FIFO_Process.elementAt(0).name + " Response Time : ===> "+
                          res_time ) ;  
       finish_time +=  FIFO_Process.elementAt(0).burst_time ; 
      for(int i=1 ; i<FIFO_Process.size() ; i++)
      {
        
         if(finish_time <=FIFO_Process.elementAt(i).arrival_time )
       {
        System.out.println(FIFO_Process.elementAt(i).name + " Response Time : ===> "+
                          0 ) ;       
      
       finish_time += ( FIFO_Process.elementAt(i).arrival_time -finish_time+
                        FIFO_Process.elementAt(i).burst_time);
       }
         
       else{
          finish_time +=  FIFO_Process.elementAt(i).burst_time ;    
       res_time = 
       finish_time - FIFO_Process.elementAt(i).arrival_time -FIFO_Process.elementAt(i).burst_time; 
        System.out.println(FIFO_Process.elementAt(i).name + " Response Time : ===> "+
                          res_time ) ; 
       }
        sum_res_time += res_time;
      }
       System.out.println(); 
        double avg= (double)sum_res_time/(double)FIFO_Process.size();
        
    System.out.println("Average  Response Time  "+ avg); 

    }
    
    
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}

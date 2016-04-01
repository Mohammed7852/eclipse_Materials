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
public class RR {
    public class field{
        String name;
        int response_time ;
        boolean flag ;
        
        public field(){
            name = "";
            response_time =0;
            flag = false ;
        }
         public field(String n , int r , boolean f){
            name = n;
            response_time =r;
            flag = f ;
        } 
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      public int Quantum  ;
      
      Vector<Process> RR_Process = new Vector<Process>();
      Vector<Process> RR_Process_order = new Vector<Process>();
      public void SetRR_Process ( Vector<Process> vec , int RR_time){
        RR_Process = vec;
        Quantum = RR_time ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      public void Execution_Order (){
         
         int res_time =0 , sum_res_time =0;
         int remind_burst_time = 0;
         int response =0;
         Vector<field> Process_Wait = new Vector<field> ();
         boolean f = true;
          while(!RR_Process.isEmpty()){
              Process current;
              for(int i = 0 ; i < RR_Process.size(); i++)
              {
                  current = RR_Process.elementAt(i); 
                  if(current.arrival_time <= sum_res_time)
                  {
                    int Minimum = Math.min(current.burst_time, Quantum);
                     current.burst_time -= Minimum;
                     sum_res_time += Minimum;
                  // for calculate first response time 
                     if(f){
                    response = sum_res_time-current.arrival_time-Minimum;  
                      //   response = sum_res_time-3;
                    Process_Wait.add(new field (current.name ,response , true));
                      f = false ;
                     }
                    for(int h=0 ; h< Process_Wait.size() ; h++){
                        boolean F = true ;
                      for(int j=0 ; j<Process_Wait.size() ; j++) { 
                        if(current.name == Process_Wait.elementAt(j).name)
                        { 
                            F = false;
                            break ;}
                      }
                      if(F){
                       
                     response = sum_res_time-current.arrival_time-Minimum ;
                     Process_Wait.add(new field (current.name , response , true));
                      }}
                   //======================================================== 
  RR_Process_order.add(new Process(current.name,current.arrival_time, current.burst_time));
    }
         else
              {
                sum_res_time++;
                  }
              } // end of outer loop 
              Vector<Process> Remaining_Process = new Vector<Process>();        
                 for(int i = 0 ; i < RR_Process.size(); i++ )
                     if( RR_Process.elementAt(i).burst_time != 0)
                         Remaining_Process.add(RR_Process.elementAt(i));
                         RR_Process = Remaining_Process;
              }
        System.out.println("RR Processes Execution Order");
        for(int j=0 ;j<RR_Process_order.size() ; j++)
        {
         System.out.print(RR_Process_order.elementAt(j).name + " ==> ");
        
        }
        System.out.println();
       
         for(int j=0 ;j< Process_Wait.size() ; j++)
        {
         System.out.println(Process_Wait.elementAt(j).name +  " Response Time : ===> " +
                 Process_Wait.elementAt(j).response_time);
             res_time += Process_Wait.elementAt(j).response_time ;
        }
            System.out.println();
            double avg= (double)res_time/(double)Process_Wait.size();
        
           System.out.println("Average  Response Time  "+ avg); 
            System.out.println();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
}

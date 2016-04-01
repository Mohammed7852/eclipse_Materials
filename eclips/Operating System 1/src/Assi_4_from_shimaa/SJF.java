/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assi_4_from_shimaa;
import java.util.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/**
 *
 * @author shimaa
 */
public class SJF {
    public boolean isBreak = false;
    Vector<Process> SJF_Process = new Vector<Process>();
    Vector<Process> sortedProcess = new Vector<Process>();
    
    public void SetSJF_Process ( Vector<Process> vec){
        SJF_Process = vec ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     public void Execution_Order (){
        
      System.out.println("SJF Processes Execution Order");
       boolean flage =true;
     // System.out.println(SJF_Process.elementAt(0).name + " Response Time : ===> (0)  ");
      int x = SJF_Process.elementAt(0).burst_time;
      // Sort Process acprrdimg to Short Burst Time 
      for(int i=1 ;i<SJF_Process.size()-1 ; i++){
          for(int j=i+1; j<SJF_Process.size();j++){
            if( SJF_Process.elementAt(i).burst_time > SJF_Process.elementAt(j).burst_time)
            {
                // Swap to Process
              Process temp = new Process
             ( SJF_Process.elementAt(i).name ,SJF_Process.elementAt(i).arrival_time,
                      SJF_Process.elementAt(i).burst_time);
              
              SJF_Process.elementAt(i).arrival_time = SJF_Process.elementAt(j).arrival_time ;
              SJF_Process.elementAt(i).burst_time = SJF_Process.elementAt(j).burst_time ;
              SJF_Process.elementAt(i).name = SJF_Process.elementAt(j).name ;
              
              SJF_Process.elementAt(j).arrival_time = temp.arrival_time ;
              SJF_Process.elementAt(j).burst_time = temp.burst_time ;
              SJF_Process.elementAt(j).name = temp.name ;
            }
          }
        }// end of sort loop
        
        Vector<Process> p = new    Vector<Process>(SJF_Process);
        p.remove(0); 
        
        while( !p.isEmpty()){
             //   boolean isBreak = false;
               for(int i=0 ; i<p.size() ; i++){
                   if(p.elementAt(i).arrival_time <= x ){
                       System.out.println(p.elementAt(i).name +"  Response Time : ===>"
                               + " (" + ( x - p.elementAt(i).arrival_time ) +")  ");
                       x += p.elementAt(i).burst_time;
                       p.remove(i);
                       break;
                   //    isBreak = true;
                   }
                   
              }
               x++;
              // if(!isBreak)x++;
        }
        
       System.out.println(); 
       sortedProcess = SJF_Process ;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void Response_Time (){
        
      int res_time=0 ;
      int finish_time=0;
      int sum_res_time =0;
     System.out.println(sortedProcess.elementAt(0).name + " Response Time : ===> "+
                          res_time ) ;  
       finish_time +=  sortedProcess.elementAt(0).burst_time ; 
      for(int i=1 ; i<sortedProcess.size() ; i++)
      {
        
         if(finish_time <=sortedProcess.elementAt(i).arrival_time )
       {
        System.out.println(sortedProcess.elementAt(i).name + " Response Time : ===> "+
                          0 ) ;       
      
       finish_time += ( sortedProcess.elementAt(i).arrival_time -finish_time+
                        sortedProcess.elementAt(i).burst_time);
       }
         
       else{
          finish_time +=  sortedProcess.elementAt(i).burst_time ;    
       res_time = 
       finish_time - sortedProcess.elementAt(i).arrival_time - sortedProcess.elementAt(i).burst_time; 
        System.out.println(sortedProcess.elementAt(i).name + " Response Time : ===> "+
                          res_time ) ; 
       }
        sum_res_time += res_time;
      }
       System.out.println(); 
        double avg= (double)sum_res_time/(double)sortedProcess.size();
        
    System.out.println("Average  Response Time  "+ avg); 

    }
    
   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assi_4_from_shimaa;

/**
 *
 * @author shimaa
 */
public class Process {
    
       public  String name ;
       public  int arrival_time ; 
       public  int burst_time ;

    public Process() {
        name = "";
        arrival_time = 0 ;
        burst_time = 0;
    }
       
      public Process( String s , int a , int b) {
        name = s;
        arrival_time = a ;
        burst_time = b;
    }
      
     
    
}

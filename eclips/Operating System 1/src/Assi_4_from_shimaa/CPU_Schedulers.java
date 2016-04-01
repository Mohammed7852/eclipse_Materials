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
public class CPU_Schedulers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
       int number_of_process ;
       Scanner sc = new Scanner(System.in);
     /*  System.out.println("Please, Enter Number of Processes : ");
       number_of_process = sc.nextInt();*/
       String Pname="" ; int arr_time = 0  ,burst_time = 0 ;
       
       Vector<Process> process = new Vector<Process> ();
        Process p1 = new Process("P1", 0, 10);
        Process p2 = new Process("P2" ,0 ,29);
        Process p3 = new Process("P3" ,0, 3);
        Process p4 = new Process("P4" ,0 , 7);
        Process p5 = new Process("P5" ,0 , 12);
        
         process.add(p1);
         process.add(p2);
         process.add(p3);
         process.add(p4);
         process.add(p5);
        
         for(int i=0 ; i< process.size() ; i++){
           System.out.println(process.elementAt(i).name + "  "+
                   process.elementAt(i).arrival_time + "  " +
                   process.elementAt(i).burst_time) ;
         }
        FCFS test = new FCFS();
        test.SetFIFO_Process(process);
        test.Execution_Order();
        test.Response_Time();
         System.out.println("\n ==================================================\n\n");
        SJF v=new SJF();
        v.SetSJF_Process(process);
        v.Execution_Order();
        v.Response_Time();
           System.out.println("\n ==================================================\n\n");
           int q ;
           System.out.println("Enter Number of Quanum  ===> ");
           q = sc.nextInt();
           RR RR_test=new RR();
           RR_test.SetRR_Process(process , q );
           RR_test.Execution_Order();
    }
}

package project1;

import java.util.*;

public class Demo {

	public static  void  main(String []args){
		 
            Map<String , Integer> m = new  HashMap();
            m.put("1", 1);
             m.put("2", 1);
              m.put("3", 3);
               m.put("4", 4);
                m.put("5", 5);
                 m.put("1", 5);
                
                 Iterator it  = m.entrySet().iterator();
                  while(it.hasNext()){
                      Map.Entry pair = (Map.Entry) it.next();
                      System.out.print(pair+" ");
                  }
                 
                 
                
            
		Place_Controller pc  = new  Place_Controller() ;
		//pc.CreatePlace();
		
 	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project1;
import java.util.*;
import java.util.ArrayList;

public class User_Controller {

      private   List<User_model> friendslist=new ArrayList();
       private  List<Place_Model>placeslist=new ArrayList();
       private List<TasteModel>tasteslist=new ArrayList(); 
        private List<User_model>userslist=new ArrayList();
        private  Map<String, User_model> notification = new  HashMap();
       private  User_model usermodel=new User_model();
        private NotificationHandlerController friendRequest  ;
        private NotificationHandlerController nhc  ;
        private Userview userview = new Userview() ;
        
        //
     
        public List<User_model> getfriends(){
            return friendslist ;
        }
        public User_Controller(){

        }
//
        public void login(String name,String password){
            User_model  um = new User_model();
            
             for(int i=0;i<userslist.size();i++){
            if(userslist.get(i).get_Uname().equals(name)&&userslist.get(i).get_password().equals(password)){
                um =userslist.get(i);
                System.out.println("go to user page");
            }    else 
                    System.out.println("you don't have Account you should sign up");
            }
            this.usermodel = um ;
             userview.view(usermodel , this);
           }//log in
        //
       public void signUp(String name,String Email,String password,String type){

                   usermodel.set_Uname(name);
                   usermodel.set_mail(Email);
                   usermodel.set_password(password);
                   usermodel.set_type(type);
                   userslist.add(usermodel);
                   
                    userview.view(usermodel ,this);
       }//sign up

       public String  forgetpassword(String Email){
           String str ="nothing";
            for(int i=0;i<userslist.size();i++){
             if(userslist.get(i).get_Email().equals(Email)){
                return str=(userslist.get(i).get_password());
                }
              }
            
            return str;
        } //forget password 

       public boolean sendFriendRequest(String receiver  ,User_model sender){
           User_model um = new User_model();
           
           boolean temp = false;
            for(int i=0;i<userslist.size();i++) {
                if(userslist.get(i).get_Uname().equals(receiver)){
                    um = userslist.get(i);
                   friendRequest = new FriendRequestNotification();
                   friendRequest.handlenotification(sender, um);
                   temp =true;
                   break;
                }
             }
            
            return temp ;
          }
       
       public void  shownotifications(
               Map<String , User_model> m1 ,
               Map<String ,User_model> m2  ,
               Map<String , User_model> m3 ) {
           nhc = new NotificationHandlerController();
           nhc.getallnotification(m1, m2, m3);
        }
        public void acceptFriendRequest(String message,User_model sender){
//           
//           String notiy;
//          notiy= friendRequest.reciveFriendRequest(sender,this);
//           if(notiy.equals("accept"))
//           {
//               friendslist.add(sender);
//               System.out.println(sender.get_Uname()+" become your friend");
//           }


       }

        
       public void getCurrentActive(){

           for(int i=0;i<friendslist.size();i++){

               if(friendslist.get(i).getActive())

                   System.out.println(friendslist.get(i).get_Uname());
           }

       }


}

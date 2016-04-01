package project1;

import java.util.*;

public class MessageNotification extends NotificationHandlerController{

     
    private  String notification ="";
    private  User_model  usermodel = new  User_model();
    private  User_Controller usercontroller =new User_Controller();
    
     public void  handlenotification(User_model sender , User_model receiver ){
        notification ="User "+sender.get_Uname()+" Sent you a message ^_^ .";
        receiver.addmessagenotification(notification , receiver);
    }
    
     
     
     
     
}//class 

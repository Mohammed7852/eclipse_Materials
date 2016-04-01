package project1;

import java.util.*;


class NotificationHandlerController {
    
    User_Controller usercontroller;
    String typeofnotfication;
    String Message;
    String time;
    Notification_View  nview =new Notification_View() ;
    
    public void  getallnotification(
            Map<String ,User_model> friend ,
            Map<String ,User_model>  message  ,
            Map<String ,User_model>  like){
        
        nview.view();
        nview.friends(friend);
        nview.messages(message);
        nview.likes(like);
    }
    
    public void  handlenotification(User_model sendr , User_model receiver ){
        
    } 
    
   
    
    
    
    
    
    
    
    
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

   
    public void setTypeofnotfication(String typeofnotfication) {
        this.typeofnotfication = typeofnotfication;
    }

    public void setM(User_Controller m) {
        this.usercontroller = m;
    }

    
    public String getTime() {
        return time;
    }

    public String getTypeofnotfication() {
        return typeofnotfication;
    }

    public User_Controller getM() {
        return usercontroller;
    }
   
   
    public void getAllNotification()
    {

    }
    public void handleNotfication()
    {
    
    }
    
	public static void main(String  []aregs){
		
		System.out.print("mohammed alil ");
	}
}

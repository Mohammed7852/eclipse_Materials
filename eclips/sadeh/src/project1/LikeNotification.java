package project1;

public class LikeNotification extends  NotificationHandlerController{

    
    private  String notification ="";
    private  User_model  usermodel = new  User_model();
    private  User_Controller usercontroller =new User_Controller();
    
    
     public void  handlenotification(User_model sendr , User_model receiver ){
        
         String notify ="User "+sendr.get_Uname()+"  like you activity\n"
                 + "";
         receiver.addlikenotification(notify , receiver);
     }



}

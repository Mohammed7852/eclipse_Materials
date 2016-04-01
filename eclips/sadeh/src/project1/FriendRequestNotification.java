package project1;

public class FriendRequestNotification extends NotificationHandlerController{

    
    private  String notification ="";
    private  User_model  usermodel = new  User_model();
    private  User_Controller usercontroller =new User_Controller();
    
     public void  handlenotification(User_model sender , User_model receiver ){
         notification ="User:-"+sender.get_Uname()+"  Requested a Friendship  with you ^_^ .";
        receiver.addfriendntification(notification ,sender);
    }
    
     
}

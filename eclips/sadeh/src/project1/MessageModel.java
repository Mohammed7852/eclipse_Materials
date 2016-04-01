package project1;

import java.sql.Date;

public class MessageModel {

	private User_model Sender  ;
	private  ConversationModel conversation ;
	private  String content  ;
	private  Date Time   ;
	
	
	//------
	
	public MessageModel(User_model  sender , ConversationModel  conver , String  cont , Date  time) {
		this.Sender = sender ;
		this.content = cont  ;
		this.conversation = conver ;
		this.Time  = time ;
 	}
	
	public void  AddNewMessage(){
		
	}
	
	public void  UpdateMessage(){
		
	}
	
}//class 

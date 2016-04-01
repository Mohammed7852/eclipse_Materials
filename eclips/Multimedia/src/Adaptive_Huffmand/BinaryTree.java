package Adaptive_Huffmand;

import java.util.*;
import java.io.*;


public class BinaryTree {

	public BinaryTree(){}

	Tree tree = new Tree();
	Scanner cin= new Scanner(System.in);
	Data Data = new Data();
	Node foundnode ;
 	static String  nyt=null;
	String s1="1";
	String s2="0";
	static String result="";
	static Node root= null ;
	boolean check_if_found;
	int  number = 100;
	
	public void  AddNode(Data data){
		
		Node newnode = new Node(data);

		if(root==null){
			root  = newnode;
		}else{
			Node focus = root ;
			Node  parent ;
			
			while(true){
				parent = focus  ;
				
				if(data.getNumber()  < focus.data.getNumber()){
					focus = focus.LeftChild ;
					if(focus==null){
						parent.LeftChild = newnode;
						return ;
					}
 				}else {
 					focus = focus.RightChild ;
 					if(focus == null){
 						parent.RightChild = newnode;
 						return ;
 					}
 				}
				
			}
		}
	}//Add Node  
	
	public void TraverdeTree(Node  focus  ){
		if(focus!=null){
			TraverdeTree(focus.LeftChild);
			System.out.println(focus);
			TraverdeTree(focus.RightChild);
		}
	}//end  traverse 
	private String  find_code ="" ; 
	
	
	/***********************************************************///add
	
	public void add(Character ch ){
		System.out.println("\twe are in add ="+ch+" \n");
		
		 int  x = ch ;
		 Node newnode1 , newnode2 ;
		 Data d1  = new Data();
		 Data d2 = new Data();
 		if(root==null){//if  the ch  is  the  first character  
			Data d = new Data();
			
			d.setIsroot(true);
			d.setNumber(number--);//number
			d.setCounter(1);
			root = new Node(d);
			root.parent = null ;
			
  			d1.setChar(ch);
 			d1.setCode(s1);
 			d1.setNumber(number--);//number--
 			d1.setCounter(1);
 			
 			d2.setCode(s2);
 			d2.setNumber(number--);//number--
 			
 			newnode1=new Node(d1);
			newnode2= new Node(d2);
			
 			newnode1.parent =root ;
 			newnode2.parent=root ;
 			
            newnode1.isright=true;
            newnode2.isleft=true; 
            
			System.out.println("we add this node:"+newnode1+"\n");
			root.RightChild = newnode1;
			root.LeftChild =  newnode2;
			
			result +=Integer.toString(x);
 			nyt="0";
		}else{
			
			Node exist = find(root , ch);
			System.out.println("result of find character ::: "+ch+"  is ="+check_if_found+" "
					+ " and the node is ="+foundnode+"\n");
			if(check_if_found){//if character is  already exist
				System.out.println("we  found  this char  :its  code  is  :"+find_code+"  and  the node is :"
						+ exist+"\n");
				result+=find_code;
				find_code="";
				 go_back(foundnode);

			}else{//character  is  not exist
 				result +=nyt+Integer.toString(x);
 				System.out.println("result now is : "+result+"\n");
				//Node newnode = root ;
				search_for_nyt(root , ch);
			}
		}
	}
	
	/************************************************************///search 
	
	public boolean search_for_nyt (Node  node , Character ch ){
		//System.out.println("\twe are in search for nyt\n");
		
		Node newndoe ;
		if(node!=null){
			if(!node.data.isIsroot()){
 				String temp = node.data.getCode();
 				//System.out.println("temp="+temp+"       nyt="+nyt+"\n") ;
			if(temp.equals(nyt)){
 				Data d1 =new Data();
				Data d2 = new Data();
				d1.setChar(ch);
				d1.setCode(node.data.getCode()+s1);
				d1.setNumber(number-- );
				d2.setCode(node.data.getCode()+s2);
				d2.setNumber(number--);
				nyt  = node.data.getCode()+s2;/////
				
 				Node newnode1 = new Node(d1);
 				Node newnode2 = new Node(d2);
 				
				node.LeftChild = newnode2;
				node.RightChild = newnode1;
				
				newnode1.isright=true;
				newnode2.isleft=true;
				
				newnode1.parent=node  ;
				newnode2.parent=node;
				
				System.out.println("we add this node right :\n"+newnode1+"       \nand this to left ::"+newnode2+"\n");
				//setcodes(root);
				//setnumbers(root);
 				go_back(newnode1);
				
				 return true;
			}
 			}
			search_for_nyt(node.LeftChild, ch);
			search_for_nyt(node.RightChild , ch);
		}
		return false;
	}
	
	/************************************************///Go_back
	boolean swaped = false  ;
	public void  go_back(Node  focus){
		 //System.out.println("we are in( go back )node is :"+focus+"\n");
		  Node  temp = focus  ;
 		  if(focus.data.isIsroot()){
			  int  last_root_counter = focus.data.getCounter() ; 
			  focus.data.setCounter(last_root_counter+1);
			  return ;
		  }else{
		  boolean  check_result = check(root , focus);
		 // System.out.println("result of check is ="+check_result+"\n");
			if(swaped){
				System.out.println("result of check is ="+check_result+"\n");
				setcodes(root);
 				//setnumbers(root);
				}
			int  last_counter = focus.data.getCounter() ; 
			focus.data.setCounter(last_counter+1);
 			go_back(focus.parent);
		}
	}
	/*****************************************************//////
	boolean parent  =false; 
	public boolean check_if_parent( Node focus , Node  node){
		//System.out.println("we are in check if  parent ::focus ="+focus+"      node="+node+"\n");
 		boolean temp = false;
		 if(focus!=null){
			 int  num = focus.data.getNumber() ; 
 			 if(num==node.data.getNumber()){
 				 parent=true;
				 temp= true;
				 return true;
			 }
			   check_if_parent(focus.LeftChild ,   node);
			   check_if_parent(focus.RightChild ,   node);
		 }
 		 return temp ;
	}
	/************************************************************///check
	public boolean   check(Node  focus  , Node  node){
		//System.out.println("we in check function  :\n   focus :::"+focus+"      \n\n    :::node="+node+"\n");
		boolean temp =false; 
		if(focus!=null){
			
			if(!focus.data.isIsroot()){
			
				int  num1 = focus.data.getNumber() , 
				     num2 = focus.data.getCounter() ; 
			
				Character  ch1 = node.data.getCode().charAt(0)  ,
					       ch2 = focus.data.getCode().charAt(0) ; 
			
			//System.out.println(num1+"\n");
			
			boolean isparent =check_if_parent(  focus, node) ;
					System.out.println("isparent  = "+isparent+" \n");
			 if(parent){
				 System.out.println("the :"+focus  +"     is  parent  of  ::"+node+"\n");
				 parent = false;
 			 }
			 
			if(num1>node.data.getNumber()&&node.data.getCounter()>=num2){
				if(!parent){	
 					System.out.println("\t----------------------Swapping------------------\n");

					Node  temp1 = node.parent  , temp2 = focus.parent , swap  ;
 					System.out.println("we need to swap focus =::"+focus+""
							+ "\n by this node=::"+node+"\n");
					
					 System.out.print("focus  parent  is  :"+temp2+"  "
					 		+ " \nthe  node parent  is  ::"+temp1+"\n" );
				
					 num1 = focus.data.getNumber();
				     num2 = node.data.getNumber();
			 	
				     Node tempnode = new Node () , 
				    		 tempfocus = new Node() , 
				    		 nodeswap = new Node()
				    		 , focusswap= new Node() ;
				    tempfocus= focus  ;
				    
				    
				    
				     
				     
//				     
//				Data d= new Data();
//				Data d1 = new  Data();
//				d1=node.data;
//				d1.setNumber(num1);
//				
//				d= focus.data;
//				d.setNumber(num2);
//				
//				node.data = d  ;
//				focus.data=d1; 
//				
//		            
//		       swaped= true ;
//				
				
					 System.out.print("new focus  ="+temp2.RightChild +"     \nnew node ="+
					 temp1.RightChild+"\n");
					
					temp = true ;
					return true;
				}
				parent = false;
			}
 		}
 			check(focus.LeftChild,  node);
 			check(focus.RightChild,  node);
		}
		
		return temp;
	}
	
	/********************************************************************///find
 	public Node find(Node  focus  , Character ch ){
  		//System.out.println("we are in (find) we find ="+ch+"  in node ="+focus+"\n");
 		
		boolean temp =false;
		if(focus!=null){
			Character  ch1  =  focus.data.getChar() ; 
			if(ch1==ch){
				find_code = focus.data.getCode();
				check_if_found=true ;
				foundnode=focus;
 				return focus;
			}
			find(focus.LeftChild , ch);
			find(focus.RightChild , ch);
		}
		return focus;
 	}
	/********************************************************************///setcodes
	public void setcodes(Node focus){
		if(focus!=null){
			if(focus.data.isIsroot()){//this means  it is  a root 
				focus.RightChild.data.setCode(s1);
				focus.LeftChild.data.setCode(s2);
			}else{
			String st = focus.data.getCode() ;
			 if(focus.RightChild!=null)
				 focus.RightChild.data.setCode(st+s1);
			 if(focus.LeftChild!=null)
				 focus.LeftChild.data.setCode(st+s2);
  			}
			setcodes(focus.RightChild);
			setcodes(focus.LeftChild);
		}
	}
	
	/********************************************************************///setnumbers
	
	public void setnumbers(Node focus){
		
	}
	/************************************///print
	public static void print(Node focus){
		
		if(focus!=null){
			print(focus.LeftChild);
 			System.out.println("node = "+focus+"");
			print(focus.RightChild);
		}
	}
	
	/********************************************************************////main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  string = "ABCCCAAAA" ;
		BinaryTree thetree = new BinaryTree();
		int  i =0;
		 
		
		for(  i=0 ;i<string.length() ; i++){
			Character ch =string.charAt(i);
			thetree.add(ch);
			//System.out.println("nyt="+nyt+"\n\t---------print----------\n");
			// print(root);
			 
		}
		
		 System.out.print("Compression Reuslt is  ::"+thetree.result);
	}//main 
	
	
	/*******************************************///class Node 
	
	static class  Node{
		 Node(){}
		Data data  ;
		Node LeftChild  ;
		Node RightChild  ;
		boolean isleft ;
		boolean  isright ;
		Node parent  ; 
		Node(Data d){
			data = d;
		}
		public void set(Data d){
			data = d;
		}
		public String toString(){
			return  "  counter ="+data.getCounter()+"    code ="+data.getCode()
			        +"  number ="+data.getNumber()+"    character="+data.getChar()+" is root="+data.isIsroot()+" \n";
		}
	}//Node 

}

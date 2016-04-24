/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia.VectorQuantization;

/**
 *
 * @author mohamed ali shabanah
 */
  import java.util.*;
 public class DevideImage {
	 
	 //--------------
 	private  Scanner cin = new Scanner(System.in);
	private List<List<Integer>> BlockesList = new ArrayList();
	private List<Float> AvirageList = new ArrayList();
	private  List<List<Float>> VectorsList = new  ArrayList();
	private  String  CompressedImage []    ;
	private int size = 0   ;
	private  Map<String , List<Float>> DeMap = new  HashMap();
	
 	//-----------
	
	private  int  [][]Matrix  ;
	private int CodeBookNumber;
	private int VectorWidth;
	private int Vectorhighet;
	private int ImageWidth;
	private int ImageHighet;
	
	//-------------
	
	public void  SetMatrix(int [][]M , int highet , int  width , int  vhigh , int  vwidth , int numbooks ){
            System.out.println("\tSetMatrix\n");
		this.Matrix=M;
		this.ImageHighet=highet;
		this.ImageWidth=width;
		this.Vectorhighet=vhigh;
		this.VectorWidth=vwidth;
		this.CodeBookNumber = numbooks;
	}
	
	
	//---------------
	
  	public void  Devide (){
  		System.out.println("\tDevide Matrix\n");
		int count = 0;
 		int s1=0 ,s2=0 ,e1=VectorWidth,e2=Vectorhighet;
 		List<List<Integer>>l = new ArrayList();
		List<Integer> li = new ArrayList();
		
 		while(true){
 			for(int i=s1;i<e1;i++){
				for(int j=s2 ;j<e2;j++){
					li.add(Matrix[i][j]);
 				}
			}
 			l.add(new ArrayList(li));
 			//System.out.println(li);
 			li.clear();
 			s2=e2;
			e2=e2+Vectorhighet;
 			if(s2>=ImageHighet){
				s2=0;
				e2=Vectorhighet;
				s1=e1;
				e1=e1+VectorWidth;
			}
			if(s1==ImageWidth)break;
 			count++;
		}
 		BlockesList=new ArrayList(l);
 		templist = new  ArrayList(BlockesList);
  		for(List<Integer> c : templist){
			System.out.println(c);
		}
		
		this.size=templist.size();
                //call Avirages method
 		 GetAvirages();
                //call Vectors  method
 		 GetVectors();
                 //Decompress Image
                 Decompression();
 	}//Devide
	
  	
  	
  	//----------------
  	
  	private  int  length ;
  	private  List<List<Integer>> templist = new  ArrayList();
  	
  	//-----------------
  	
	public List<Float> GetAvirages(){
            System.out.println("\tGet Avirages\n");
		List<Float>lf  = new ArrayList();
   		float d1 =0,d2 ;
 		int sum ;
 		length = Vectorhighet*VectorWidth ;
 		//System.out.println("length="+length+" size="+size +"   templist =\n"+templist+"\n");
		for(int i=0;i<length ;i++){
			sum=0;
			for(int j=0;j<size;j++){
				sum+=templist.get(j).get(i);
			}
			d1=(float)sum /size;
			lf.add(d1);
		}
		System.out.println("avirage is :\n"+lf+"\n");
		AvirageList = new ArrayList(lf);
 		return AvirageList;
	}//
	
	
	//----------------
	
	public void  GetVectors(){
            System.out.println("\tGetVectors\n");
 		VectorsList.add(AvirageList);
  		int  counter= 0 ; 
 	while(true){
 		List<Float> temp = new ArrayList();
 		List<Float> Right = new ArrayList();
 		List<Float> Left = new ArrayList();
 		List<List<Float>> ListOfAll = new  ArrayList();
                
 			for(int  i=0;(i<=counter&&counter==0)||(i<counter) ;i++){
				temp = VectorsList.get(i);
 				for(float f : temp){
					float right = (float) Math.floor(f+1) ;
					float left = (float)Math.ceil(f-1);
					Right.add(right);
					Left.add(left);
  				}//for  list
 				System.out.println("Left="+Left+"   , Right="+Right+"\n");
				ListOfAll.add(new  ArrayList(Left));
				ListOfAll.add(new ArrayList(Right));
				Right.clear();
				Left.clear();
			}//for   i
 			VectorsList.clear();
 			counter+=2;
 			
			Vector<List<Integer>> v[] = new  Vector[counter];
			for(int i=0;i<counter;i++)
				v[i]= new  Vector();
			
 			
  		 float summations  []= new  float[counter];
		 for(int  k=0  ;k<ListOfAll.size();k++){
				for(float f :ListOfAll.get(k)){
					summations[k]+=f;
				}
				System.out.println("Summation of  #"+(k+1)+" ="+summations[k]+"\n");
			}//for  k

 		for(int  i=0;i<size;i++){
 			
			List<Integer> LI = new  ArrayList(new  ArrayList(BlockesList.get(i)));
			int  sum =0 ;
			for(int  x:LI)sum+=x;
 			float diff[] = new  float [counter];
			 for(int  k=0 ;k<counter;k++){
				 diff[k]=Math.abs(summations[k]-sum) ;
			 }//for k
			 int  index=0  ;
			 
			 for(int  k=0;k<counter;k++){
 				if((sum<=summations[k])||((k+1)==counter)||(diff[k]==diff[k+1])){
 					index=k;
 					break;
 				} else  if((sum>summations[k]&&sum<summations[k+1])&&(diff[k]<diff[k+1])&&counter>2){
 					index=k;
 					break;
 				}
 			}
			 
 		 
			  System.out.println("index="+index+"  ,we check :"+LI+"   , sum="+sum+"\n");
 			
			   
			  v[index].addElement(new  ArrayList(LI));
 		}//for  i 
 			
 		for(int  i=0;i<counter;i++){
				templist = v[i];
				System.out.println("Avirage #"+(counter+1)+"  is  :"+ListOfAll.get(i)+"     and has follwing  lists belong it ::\n"
						+ templist+"\n");
				this.size = templist.size() ;
				List<Float>lfloat = GetAvirages() ;
				VectorsList.add(new  ArrayList(lfloat));
			}//for   i 
 		System.out.println("Now Vector list is  ::"+VectorsList+"\n\n");
		if(counter+2>CodeBookNumber){
			FurtherChecking(counter, new  ArrayList(VectorsList));
			break;
		}
		
 		}//while
 	}//end  method 
	
	//-----------------------
	
	public void FurtherChecking(int  counter , List<List<Float>> ListOfAll){
                        System.out.println("\tFurther  checking\n");
                        
		Map<List<Integer> , Integer>map = new HashMap();
 		Vector<List<Integer>> v[] = new  Vector[counter];
		for(int i=0;i<counter;i++)
			v[i]= new  Vector();
		
			
			 
		 float summations  []= new  float[counter];
	       for(int  k=0  ;k<ListOfAll.size();k++){
			for(float f :ListOfAll.get(k)){
				summations[k]+=f;
			}
			System.out.println("Summation of  #"+(k+1)+" ="+summations[k]+"\n");
		}//for  k

		for(int  i=0;i<size;i++){
			
		List<Integer> LI = new  ArrayList(new  ArrayList(BlockesList.get(i)));
		int  sum =0 ;
		for(int  x:LI)sum+=x;
			
			
			float diff[] = new  float [counter];
		 for(int  k=0 ;k<counter;k++){
			 diff[k]=Math.abs(summations[k]-sum) ;
		 }//for k
		 int  index=0  ;
		 
		 for(int  k=0;k<counter;k++){
				if((sum<=summations[k])||((k+1)==counter)||(diff[k]==diff[k+1])){
					index=k;
					break;
				} else  if((sum>summations[k]&&sum<summations[k+1])&&(diff[k]<diff[k+1])&&counter>2){
					index=k;
					break;
				}
			}
		 
		 
		  System.out.println("index="+index+"  ,we check :"+LI+"   , sum="+sum+"\n");
			map.put(LI, index);
		   
		  v[index].addElement(new  ArrayList(LI));
		}//for  i 
		VectorsList.clear();
		for(int  i=0;i<counter;i++){
			templist = v[i];
			System.out.println("block #"+(counter+1)+"  is  :"+ListOfAll.get(i)+"     and  the temp list now ::\n"
					+ templist+"\n\n");
			 this.size = templist.size() ;
			List<Float>lfloat = GetAvirages() ;
			VectorsList.add(lfloat);
		}//for   i 
		 System.out.println("Now Vector list is  ::"+VectorsList+"\n\n");
		if(ListOfAll.equals(VectorsList)){
 			System.out.println("yes  equal"+"\n"+map);
			Compression( counter, map , new ArrayList(VectorsList));
		}else   
		{ 
			map.clear();
			FurtherChecking(counter, new  ArrayList(VectorsList));
 		}
	}//further checking
	
	
	//----------------------
	
	public void Compression(int  counter  ,Map<List<Integer>, Integer> map , List<List<Float>> lf){
                    System.out.println("\tCompression\n");
		int sz  = lf.size();
		int  x  =(int) Math.ceil(Math.log(length));
		System.out.println("size="+size+"   , number  of  bits="+x+"\n");
		String  []labels = new String  [counter];
		
		for(int  i=0 ;i<counter ;i++){
			labels[i] = Integer.toString(i,2);
			DeMap.put(labels[i], VectorsList.get(i));
		}
		
		for(String  s :labels){
			System.out.print(s+"  ");
		}//for string 
		System.out.println();
                System.out.println();
		
		String []Array = new  String  [size];
		CompressedImage = new  String  [size];
		
		for(int  i=0 ;i<size;i++){
			List<Float>l = new ArrayList(new  ArrayList(BlockesList.get(i)));
			int  index  = map.get(l);
			Array[i]=labels[index];
 		}//for i 
		int  c=  0;
                System.out.println("\tCompressed Image is :\n");
		for(int  i=0 ;i<size;i++){
			c++;
			System.out.print(Array[i]+"  ");
			// if(c==3){System.out.println();c=0 ;}
		}
		CompressedImage = Array ;
                /**
                we  will save  Compressed  image  in file ,,, and  VectorsList  as an Overhead, to be  read when decompression 
                
                */
		//Decompression();
	}///metod
	
	
	//-----------------
	
	public void  Decompression(){
 		System.out.println("\n\tDecompression\n");
		System.out.println(""+VectorsList+"\n");
 		int  c= 0 ;
 		for(int  i=0 ;i<size;i++){
			c++;
			System.out.print(CompressedImage[i]+"  ");
			// if(c==3){System.out.println();c=0 ;}
		}
		List<List<Float>> Result  = new ArrayList();
		for(int  i=0 ;i<size;i++){
			String  temp = CompressedImage[i];
			List<Float> lf  = new  ArrayList(DeMap.get(temp));
			Result.add(new  ArrayList(lf)); 
 		}
		for(int  i=0 ;i<size ;i++){
			System.out.println("Original  ::\n"+BlockesList.get(i)+"   ");
			System.out.print("    Result  Image  is :"+Result.get(i)+"\n");
		}
		
		//*******
		
		ReConstructMatrix(BlockesList);
		
		
	}
	
	//-------------------
	
	public void ReConstructMatrix(List<List<Integer>> Result){
		
		int sz  = Result.size();
		int  Array [][] = new  int[6][6] ;
		
		
 		 int  array [][] = new  int  [9][4];
		
		for(int  i=0 ;i<9 ;i++){
			for(int  j=0 ;j<4;j++){
				array[i][j]=Result.get(i).get(j);
				System.out.print(array[i][j]+"  ");
			}
			System.out.print("  \n");
		}
		
		
		int s1=0 , e1 = 2 , s2 = 0 ,e2 = 2 ;
		
		while(true){
			
			for(int  i=s1 ; i<e1 ;i++){
				for(int  j=s2 ; j<e2 ;j++){
					
				}
			}
		}
		
		
	}
	
	
 }//class

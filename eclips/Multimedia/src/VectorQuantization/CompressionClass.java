/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VectorQuantization;

/**
 *
 * @author mohamed ali shabanah
 */

import java.util.*;
import  java.io.*;
public class CompressionClass {
	 
	 //--------------
 	private  Scanner cin = new Scanner(System.in);
	private List<List<Integer>> BlockesList = new ArrayList();
	private List<Float> AvirageList = new ArrayList();
	private  List<List<Float>> VectorsList = new  ArrayList();
	private  String  CompressedImage []    ;
	private int size = 0   ;
	private  Map<String , List<Float>> DeMap = new  HashMap();
        private  float [][] FinalMatrix ;
	private  int  NumberOfBlocks  ;
    private  int  [][]MaxError  ;
    private  int  [][]Origin ;
    private  String  input  , dictionary  ;
        
  	//-----------
	
	private  int  [][]Matrix  ;
	private int CodeBookNumber;
	private int VectorWidth;
	private int Vectorhighet;
	private int ImageWidth;
	private int ImageHighet;
	private  float MeanSquareError ;
	//-------------
public int [][]  GetMAtrix(){
            return Matrix ;
        }
        public int  [][]GetMaxError(){
            return MaxError ;
        }
        public float Get_MSE(){
            return MeanSquareError / (ImageHighet*ImageWidth) ;
        }
        //--------------------
        
public void  SetMatrix(int [][]M , int highet , int  width , int  vhigh , int  vwidth , int numbooks , String in , String  dic ){
            System.out.println("\tSetMatrix\n");
		this.Matrix=M;
                this.Origin = M ;
		this.ImageHighet=highet;
		this.ImageWidth=width;
		this.Vectorhighet=vhigh;
		this.VectorWidth=vwidth;
		this.CodeBookNumber = numbooks;
        this.length = VectorWidth*Vectorhighet ;
        this.input=in;
        this.dictionary = dic  ;
	}
	
	
	//---------------
	
public void  Devide (){
  		System.out.println("\tDevide Matrix\n");
		int count = 0;
 		int s1=0 ,s2=0 ,e1=Vectorhighet,e2=VectorWidth;
 		List<List<Integer>>l = new ArrayList();
		List<Integer> li = new ArrayList();
		
 		while(true){
                    
 			for(int i=s1;i<e1;i++){
				for(int j=s2 ;j<e2;j++){
					li.add((Matrix[i][j]));
 				}
			}
 			l.add(new ArrayList(li));
 			//System.out.println(li);
 			li.clear();
 			s2=e2;
			e2=e2+VectorWidth;
 			if(s2>=ImageWidth){
				s2=0;
				e2=VectorWidth;
				s1=e1;
				e1=e1+Vectorhighet;
			}
			if(s1==ImageHighet)break;
 			count++;
                       // System.out.print(count+" ,");
		}
 		BlockesList=new ArrayList(l);
 		templist = new  ArrayList(l);
              
 		System.out.print("\nThe  Image Blockes are :\n");
  		
         for(List<Integer> c : templist){
			System.out.println(c);
		}
                
		NumberOfBlocks = new  Integer(BlockesList.size());
                
		this.size=new  Integer(templist.size());
                //call Avirages method
 		 GetAvirages();
                //call Vectors  method
 		 try {
			GetVectors();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                 //Decompress Image
        // Decompression();
 	}//Devide
	
  	
  	
  	//----------------
  	
  	private  int  length ;
  	private  List<List<Integer>> templist = new  ArrayList();
  	
  	//-----------------
  	
public List<Float> GetAvirages(){
            //System.out.println("\tGet Avirages\n");
		List<Float>lf  = new ArrayList();
   		float d1 =0 , d2 ;
 		int sum ;
  		//System.out.println("length="+length+" size="+size +"   templist =\n"+templist+"\n");
         for(int i=0;i<length ;i++){
			sum=0;
			for(int j=0;j<size;j++){
				sum+=templist.get(j).get(i);
			}
			d1=(float)sum /size;
			lf.add(d1);
		}
		//System.out.println("avirage is :\n"+lf+"\n");
		AvirageList = new ArrayList(lf);
 		return AvirageList;
	}//
	
	
	//----------------
	
public void  GetVectors() throws FileNotFoundException{
           
		System.out.println("\tFunction ::GetVectors\n");
 		VectorsList.add(AvirageList);
  		int  counter= 0 ;
  		
 	while(true){
 		
 		List<Float> temp = new ArrayList();
 		List<Float> Right = new ArrayList();
 		List<Float> Left = new ArrayList();
 		List<List<Float>> ListOfAll = new  ArrayList();
                
 		int  Size = VectorsList.size();
 		
 			for(int  i=0;  i<Size/*(i<=counter&&counter==0)||(i<counter)*/ ;i++){
				temp = VectorsList.get(i);
 				for(float f : temp){
					float right = (float) Math.floor(f+1) ;
					float left = (float)Math.ceil(f-1);
					Right.add(right);
					Left.add(left);
  				}//for  list
 				//System.out.println("for the  average :"+temp+" , it has ::\n"+""
                                  //      + "Left="+Left+"   , Right="+Right+"\n");
                                
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
                 //getting  the summation of  Averages  each one  alone 
                            
 		 for(int  i=0;i<NumberOfBlocks;i++){
 			List<Integer> LI = new  ArrayList(new  ArrayList(BlockesList.get(i)));
			int  sum =0 ;
			//for(int  x:LI)sum+=x;//summation of  elements  in the  original block 
 			float diff[] = new  float [counter];
                        
                       
 
                        //this loops give the  difference  between original and  each average  list 
            int sz  = LI.size() ; 
            int  minindex  ;
            
            float   Sum = 0;
           for(int  j=0  ;j<counter;j++){
            for(int n=0 ; n<sz  ;n++){
                Sum+=Math.abs(LI.get(n)-ListOfAll.get(j).get(n)) ;
              //  int  dif = Math,
            }
            diff[j] = Sum ;
            Sum = 0;
                }
    

         float min = diff[0]  ;
                 int  index=0  ;
                 for(int  k=1 ; k<counter ;k++){
                     if(diff[k]<min){
                         min=diff[k];
                         index = k ;
                     }
                 }
                
 
			  //System.out.println("index="+index+"  ,we check :"+LI+"  , min= "+min+"  , sum="+sum+"\n");
 			
			   
			  v[index].addElement(new  ArrayList(LI));
 		}//for  i 
 			
 		for(int  i=0;i<counter;i++){
				templist = v[i];
				//System.out.println("\tAvirage #"+(i+1)+" is  :"+ListOfAll.get(i)+"  \n\tand has follwing  lists belong it ::\n"
				//		+ templist+"\n");
				this.size = templist.size() ;
				List<Float>lfloat = GetAvirages() ;
				VectorsList.add(new  ArrayList(lfloat));
			}//for   i 
 		System.out.println("\tNow Vectors are ::\n"+VectorsList+"\n\n");
                
		if(counter+2>CodeBookNumber){//at this  moment  we  have  all vectors  List 
			//here  we  make  further  checking 
			FurtherChecking(counter, new  ArrayList(VectorsList));
			break;
		}
		
 		}//while
 	}//end  method 
	
	//-----------------------
	
public void FurtherChecking(int  counter , List<List<Float>> ListOfAll) throws FileNotFoundException{
                        System.out.println("\tFunction ::Further  checking\n");
                        
		Map<List<Integer> , Integer>map = new HashMap(); // here  all original block has  a pointer to  the vector  
  		Vector<List<Integer>> v[] = new  Vector[counter];
		
                for(int i=0;i<counter;i++)
			v[i]= new  Vector();
		
			
			 
	       float summations  []= new  float[counter];
	     
	for(int  i=0;i<NumberOfBlocks;i++){
		List<Integer> LI = new  ArrayList(new  ArrayList(BlockesList.get(i)));
		int  sum =0 ;
		//for(int  x:LI)sum+=x;
 		float diff[] = new  float [counter];
		int  minindex  ;
        float   Sum = 0;
 
        //this loops give the  difference  between original and  each average  list 
 
        for(int  j=0  ;j<counter;j++){
        for(int n=0 ; n<LI.size()  ;n++){
            Sum+=Math.abs(LI.get(n)-ListOfAll.get(j).get(n)) ;
          //  int  dif = Math,
        }
        diff[j] = Sum ;
        Sum = 0;
            }
        
        float min = diff[0]  ;
         int  index=0  ;
         
         for(int  k=1 ; k<counter ;k++){
             if(diff[k]< min){
                 min=diff[k];
                 index = k ;
             }
         }
 		  //System.out.println("index="+index+"  ,we check :"+LI+"   , sum="+sum+"\n");
			map.put(LI, index);
 		  v[index].addElement(new  ArrayList(LI));
 		  
		}//for  i 
        VectorsList.clear();

        for(int  i=0;i<counter;i++){
			templist = v[i];
			//System.out.println("Average #"+(i+1)+"  is  :"+ListOfAll.get(i)+"     and  the temp list now ::\n"
					//+ templist+"\n\n");
			 this.size = templist.size() ;
			List<Float>lfloat = GetAvirages() ;
			VectorsList.add(lfloat);
		}//for   i 
		System.out.println("\tNow Vectors are  ::"+VectorsList+"\n\n");
		
        if(ListOfAll.equals(VectorsList)){
 			System.out.println("\tyes  equal"+"   and the  map is  ::\n"+map+"\n\n");
			Compression( counter, map , new ArrayList(VectorsList));
		}else   
		{ 
			map.clear();
			FurtherChecking(counter, new  ArrayList(VectorsList));
 		}
        
	}//further checking
	
	
	//----------------------
	
public void Compression(int  counter  ,Map<List<Integer>, Integer> map , List<List<Float>> lf) throws FileNotFoundException{
            System.out.println("\tFunction ::Compression\n");
		
        int sz  = lf.size();
		int  x  =(int)Math.ceil(Math.log10(CodeBookNumber)/Math.log10(2));
             
		List<String> lstring = new  ArrayList();
		
		System.out.println("number  of  bits="+x+"\n");
		String  []labels = new String  [CodeBookNumber];
		
		for(int  i=0 ;i<CodeBookNumber ;i++){
			labels[i] = Integer.toString(i,2);
			DeMap.put(labels[i], VectorsList.get(i));
		}//labels for 
		
		System.out.print("\nLabels Are:");
		for(String  s :labels){
			System.out.print(s+"  ");
		}//for string 
                 System.out.println();
		
 		CompressedImage = new  String  [NumberOfBlocks];
		
		for(int  i=0 ;i<NumberOfBlocks;i++){
			List<Float>l = new ArrayList(new  ArrayList(BlockesList.get(i)));
			int  index  = map.get(l);//index  of vector that this  block is belong to 
			CompressedImage[i]=labels[index];
			lstring.add(CompressedImage[i]);
 		}//for i 
		
		int  c=  0;
                System.out.println("\tCompressed Image is :\n");
		for(int  i=0 ;i<NumberOfBlocks;i++){
			c++;
			System.out.println("Block "+BlockesList.get(i)+"------->"+CompressedImage[i]+"  ");
			// if(c==3){System.out.println();c=0 ;}
		}

 		Writer writer ;
		try {
			writer = new  FileWriter(input);
			BufferedWriter  bw  = new  BufferedWriter(writer);
			bw.write(lstring.toString());
			bw.close();
			writer = new  FileWriter(dictionary);
			bw = new  BufferedWriter(writer);
			
			for(List<Float> l :VectorsList){
				bw.write(l.toString()+"\n");
			}
 			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		
		//Writing  labels  and  vectors  to File
		
                /**
                we  will save  Compressed  image  in file ,,, and  VectorsList  as an Overhead, to be  read when decompression 
                
                */
		
		//Decompression();
	}///metod
	
	
	//-----------------
	

 }//class

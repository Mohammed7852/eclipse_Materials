package VectorQuantization;

import  java.io.*;
import  java.util.*;

public class Decompression {

	private  int  MeanSquareError ;
	private  int  [][]MaxError ;
 	private  int [][]ErrorMAtrix  ;
	private  int [][]Matrix  ;
	private int ImageHighet , ImageWidth , VectorHighet , VectorWidth ; 
	private  int length ; 
	private  String  [] CompressedImage  ;
	private List<List<Float>> VectorsList = new ArrayList() ;
	private  String [] Labels ;
	private int  NumberofBlocks  ;
	private  String  input , output  , dictionary ;
	private int  CodeBookNumber ;
	private  Map<String , List<Float>>DeMap = new  HashMap();
	
	///***
	public int [][]  GetMatrix(){
		return Matrix ;
	}
	
	public int  geth(){
		return ImageHighet;
	}
	public int getw(){
		return ImageWidth;
	}
	//*************
public Decompression(String  dimensionfile , String Labelsfile  ,String  vectorsfile) throws IOException {
		 try {
			 
			Reader reader = new  FileReader(dimensionfile);
			BufferedReader br  = new BufferedReader(reader);
    		String  dimensions  = br.readLine() ;
    		br.close();
			ReadDimensions(dimensions);
			
			reader = new  FileReader(Labelsfile);
			br = new  BufferedReader(reader);
			String  labels  = br.readLine() ;
			br.close();
			ReadLabels(labels);
			
			reader = new  FileReader(vectorsfile);
			br  = new  BufferedReader(reader);
			String  str="";
			while((str=br.readLine()) != null){
				System.out.println(str+"\n");
				ReadVectors(str);
				//System.out.println(VectorsList+"\n");
			}
			
			
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		}
		 
		 
 	}//
	 
	//***
public void  ReadVectors(String str){
	System.out.println("\n\tFunction ::Read Vectors\n");
	
	List<Float> lfloat = new ArrayList();
	
	String temp = "";
	for(int  i=1 ;i<str.length() ;i++){
		char ch = str.charAt(i);
		
		if(ch!=','&&ch!=' '&&ch!=']'){
			//System.out.print(ch+"|");
				temp+=ch;
		}else if(ch==','||ch==']'){
			//System.out.print(temp+"&");
			lfloat .add(Float.parseFloat(temp));
			temp="";
		}else {
			
		}	
	}
	
	//System.out.println(lfloat+"\n");
	
	VectorsList.add(new  ArrayList(lfloat)) ;
	
	
}
	//******
public void  ReadLabels(String label){
	
	System.out.println("\n\tFunction ::Read Labels\n");
	 
	CompressedImage = new String  [NumberofBlocks] ;
	
 	String temp ="";
	int c= 0;
	 for(int  i=1  ;i<label.length();i++){
		 char ch = label.charAt(i);
		 if(ch=='0'||ch=='1' ){
				 temp+=ch;
		 }else if(ch==','||ch==']'){
 			 CompressedImage[c++]=temp;
 			 temp="";
		 }else{
			 
		 }
	 }
 	 
	 for(String s :CompressedImage){
		// System.out.print(s+",");
	 }
	System.out.print("\n\n");
	
}
	//*****
public void ReadDimensions(String  dim){
	System.out.println("\n\tFunction ::ReadDimensions\n");
	
	List<Integer> list = new  ArrayList();		
	String temp = "";
	
	for(int  i=0 ;i<dim.length() ;i++){
		char ch = dim.charAt(i);
		if(ch!='|'){
			temp+=ch;
		}else{
			list.add(Integer.parseInt(temp));
			temp="";
		}
		
	}//for
 	ImageHighet = list.get(0);
	ImageWidth = list.get(1);
	VectorHighet = list.get(2);
	VectorWidth = list.get(3);
	CodeBookNumber = list.get(4);
 	int x  = VectorHighet*VectorWidth ;
	int  y  = ImageHighet*ImageWidth ;
 	NumberofBlocks = y/x ;

 	//System.out.println("imagehighet ="+ImageJighet+" , imagewidth ="+ImageWidth+" ,"
 		//	+ " "+" vhighet ="+VectorHighet+" , vwidth="+VectorWidth + " , codenum="+CodeBookNumber+""
 			//		+ " , numblocks ="+NumberofBlocks+"\n\n");
 	
}//
 
	 
	 //***************

public void  Decompression(){
		System.out.println("\n\tDecompression\n");
		
	//System.out.println(""+VectorsList+"\n");
            //create  labels  as  number  of  codebook
           // System.out.print("\nNow we  are creating  labels of  length ="+CodeBookNumber+" \n");
		
		//Reading  vectors from File
		
    String  []labels = new String  [CodeBookNumber];
	
	for(int  i=0 ;i<CodeBookNumber ;i++){
		labels[i] = Integer.toString(i,2);
		DeMap.put(labels[i], VectorsList.get(i));
	}
	
	//finishing creating  labels  to each vector  
            
		 
		 
	List<List<Float>> ReconstructedImage  = new ArrayList();
	
	for(int  i=0 ;i<NumberofBlocks;i++){
		String  temp = CompressedImage[i];
		List<Float> lf  = new  ArrayList(DeMap.get(temp));
		ReconstructedImage.add(new  ArrayList(lf)); 
		}
	for(int  i=0 ;i<NumberofBlocks ;i++){
		System.out.println("------------->"
                            + ""+ReconstructedImage.get(i)+"");
	}
	 
	//*******
	
	ReConstructImageToMatrix(new  ArrayList(ReconstructedImage)/*for  example onle ,,real is  (ReconstructedImage)*/);
		
}//decomp

public void ReConstructImageToMatrix(List<List<Float>> Result){
	
          System.out.print("\n\tReConstructImageToMatrix\n");
	    int sz  = Result.size();
	 
        System.out.print("imagehighet="+ImageHighet+" , Imagewidth="+ImageWidth+"  , Vectorhighet ="+VectorHighet+""
                + "  , Vectorwidth ="+VectorWidth+"\n\n");   
         
        List<Float> l = new  ArrayList();
        List<Float> result  = new  ArrayList();
        
        float [][]matrix  = new  float [ImageHighet][ImageWidth];
        
        //System.out.print("NOW\n");

        int c = 0 ;         
        int  count=0  ,s1=0 ,e1=(ImageWidth/VectorWidth)  , s2 = 0 , e2 = VectorWidth;

         for(int  i=0 ;i<ImageHighet;i++){                 
            for(int  j=s1 ; j<e1; j++){
                l = new  ArrayList(Result.get(j));
                for(int  k= s2 ;k<e2;k++){
                    result.add(l.get(k));
                     System.out.print(l.get(k)+" ");
                   } 
                } 
               count++;
               s2=e2;
               e2=e2+VectorWidth;
                if(count==VectorHighet ){
                   s1 =e1 ;
                   e1=e1+(ImageWidth/VectorWidth);
                   s2=0;
                   e2=VectorWidth;
                   count=0;
               }
                 System.out.print(" \n");
            }
             // System.out.print("\nResulting Image 1 is ::"+result+"\n");
                // System.out.print("\n\nNow:\n"+(c)+" , , count now  is  ="+result.size()+"  , "+result.get(0)+"\n matrix=\n");
                count=0 ;           
               
                Matrix = new  int[ImageHighet][ImageWidth] ;
           
                 System.out.print("\nResulting Image  in Write is ::\n");
                 
                for(int i= 0;i<ImageHighet;i++){
                for(int  j=0 ;j<ImageWidth;j++){
                     float  x = result.get(count++);
                      matrix[i][j] = x ;
                      matrix[i][j] = (float) Math.ceil(matrix[i][j]) ; 
                      int  y = (int) matrix[i][j] ;
                      Matrix[i][j] = y ;
                     System.out.print(Matrix[i][j]+"  ");
                  }
                 System.out.print("\n");
            }
                
              // Caculate_Max_Error();
            // FinalMatrix = matrix  ;
     }//end method         

    //------------------------------------------



}//class 

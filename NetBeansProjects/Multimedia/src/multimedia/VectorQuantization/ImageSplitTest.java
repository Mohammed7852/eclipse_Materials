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
import javax.imageio.ImageIO;  
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;  
import java.awt.*;  
 import  java.util.*;

public class ImageSplitTest {  
	private  DevideImage DI = new  DevideImage();
 	private  int width , highet ; 
        private  Scanner  cin = new  Scanner(System.in);
        private  int  [][] Array ; 
 	private  ArrayList<Integer> l = new ArrayList();
//---------
       public  int  getwidth(){
           return width;
       }
       public int  gethighet(){
           return highet ;
       }
       public  int[][] GetMatrix(){
           return Array  ;
       }
      //---------- 
       
       public void  SplitTo2DArray(String path ) throws IOException{            
            System.out.println("SplitTo2DArray\n");
            Image image = ImageIO.read(new File(path));	
             BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

                Graphics g = img.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();	

                int w = img.getWidth();
		int h = img.getHeight();
                
                width=img.getWidth() ;
                highet = img.getHeight() ;
                if(width%2!=0)
                    width=width-1;
                if(highet%2!=0)
                    highet=highet-1;
                
		int[][] array = new int[highet][width];
                Array = new  int  [highet][width];
                
                System.out.println("width="+width+"    highet="+highet+"\n");
                
 		for (int j = 0; j < highet; j++) {
 		    for (int k = 0; k < width; k++) {
                        
                        int  rgp = img.getRGB(k, j);
                         int alpha  = (rgp>>24)&0xff ;
                         int  r = (rgp>>16)&0xff ;
                         int  G  = (rgp>>8)&0xff ;
                         int  b = (rgp>>0)&0xff ;
  		          Array[j][k] =r;
		        System.out.print(Array[j][k]+"  ");
		    }
		    System.out.print("\n");
		}		
 
                //DI.SetMatrix(array, h, w, x, y, 9);
		//DI.Devide();
 	 
	}//end method
	
	//------------

        public void  SplitToMultipleImages(int r , int  col) throws IOException{
		File file = new File("C:\\Users\\mohamed ali shabanah\\Documents\\eclips"
        		+ "\\Multimedia\\src\\Vector_Quantization\\bear.jpg"); // I have bear.jpg in my working directory  
        FileInputStream fis = new FileInputStream(file);  
        BufferedImage image = ImageIO.read(fis); //reading the image file  
  
        int rows = r; //You should decide the values for rows and cols variables  
        int cols = col;  
        int chunks = rows * cols;  
  
        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height  
        int chunkHeight = image.getHeight() / rows;  
        int count = 0;  
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
        for (int x = 0; x < rows; x++) {  
            for (int y = 0; y < cols; y++) {  
                //Initialize the image array with image chunks  
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  
  
                // draws the image chunk  
                Graphics2D gr = imgs[count++].createGraphics();  
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, 
                		chunkHeight * x, chunkWidth * y + chunkWidth, 
                		chunkHeight * x + chunkHeight, null);  
                gr.dispose();  
            }  
        }  
        System.out.println("Splitting done");  
  
        //writing mini images into image files  
        for (int i = 0; i < imgs.length; i++) {  
            ImageIO.write(imgs[i], "jpg", new File("img" + i + ".jpg"));  
        }  
        System.out.println("Mini images created");  
    
        }
        
	//------------
	
	public void writeImage(int  [][]_Array,  int  w  , int  h , String  path ) throws IOException {

        System.out.println("\n\tWrite Image\n");
 
        int  [][] array  = new  int  [h][w];
            array = _Array ;
             System.out.print("\n width="+width + "   highet ="+highet+"\n");
      
  
            File  Fileout = new  File(path);
            BufferedImage image  = new  BufferedImage(w , h , BufferedImage.TYPE_INT_RGB);
           
            for(int  i = 0 ; i<h ;i++){
                   for(int  j=0 ;j<w ; j++){
                       image.setRGB(j, i, (_Array[i][j]<<16)|(_Array[i][j]<<8)|(_Array[i][j]));
                    }
               }
               
                ImageIO.write(image, "jpg", Fileout) ;
 	
        }//method  write  image 
	
   
} //class  
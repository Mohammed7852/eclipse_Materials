package Prdictive_Codeing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Split_Write_Image {

	private  int  width  ,highet  ;
	int  [][]Array  ;
	String  path ;
	
	
	public Split_Write_Image(String  p) throws IOException {
		this.path = p ;
		SplitTo2DArray();
 	}
	
	
	
    public void  SplitTo2DArray( ) throws IOException{            
        System.out.println("\n\tSplitTo2DArray\n");
        
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
		
}//end method

	
	
	public int  [][]getmatrix (){
		return Array  ;
	}
	
	public int  getwidth(){
		return width;
	}
	
	public  int gethighet (){
		return highet ;
	}
	
	
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
	
	
	
	
	
}//class  

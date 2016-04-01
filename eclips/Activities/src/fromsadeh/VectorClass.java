package fromsadeh;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author mohmmed
 */

public class VectorClass {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Integer> orginal = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>>block=new ArrayList<>();
    public static int width = 0;
    public static int height = 0;
    public static   int[][] pixel ;
    public static int NumberOfBlokes;
    public static Vector<ArrayList<ArrayList<Integer>>>vec = new  Vector();
    
    ///----------------
    
   public static void writeImage(int[][] pixels, String outputFilePath) {
        File fileout = new File(outputFilePath);
        BufferedImage image2 = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image2.setRGB(j, i, (pixels[i][j] << 16) | (pixels[i][j] << 8) | (pixels[i][j]));
            }
        }
        try {
            ImageIO.write(image2, "jpg", fileout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
public static ArrayList<ArrayList<Integer>>  splitAvarage(ArrayList<Float> arr) {
     ArrayList<ArrayList<Integer>>split=new ArrayList<>();
     ArrayList<Integer>temp1=new ArrayList<>();
      ArrayList<Integer>temp2=new ArrayList<>();
        for (int i=0;i<arr.size();i++) {
            int x=(int) Math.ceil(arr.get(i)-1);
            int y=(int) Math.floor(arr.get(i)+1);
            temp1.add(x);
            temp2.add(y);
        }
        
     split.add(temp1);
     split.add(temp2);
     return split;
} 


public static int compare(ArrayList<ArrayList<Integer>>split  ,  ArrayList<Integer>data){

int index=0;
int diff=0;
int min=0;

for(int k=0;k<data.size();k++){
    min+=data.get(k)-split.get(0).get(k);
}
    for (int i=0;i<split.size();i++){
        for(int j=0;j<split.get(i).size();j++){
            diff+=data.get(j)-split.get(i).get(j);
        }
        
        if (diff<min){
        min=diff;
        index=i;
        }
    }
    return index;
}

public static void mainSplit(int numberOfVector){
    vec=new Vector<>();
    
    int counter=0;
    while(counter<=numberOfVector){
        
/* ArrayList<ArrayList<Integer>>split=null;
 ArrayList<Float>avg=getAvarage(arr);
   split= splitAvarage(avg);
  */
     struct avg[];
     struct split[];   
     
        if (counter==0){
       avg=new struct[1]; 
       split=new struct[1];
       avg[0]=new struct();
       split[0]=new struct();
      
       avg[0].avarage=getAvarage(block);
       split[0].obj=splitAvarage(avg[0].avarage);
       System.out.println(split[0].obj.size());
        }
        else {
            System.out.println("I am in step 2");
        avg=new struct[counter]; 
        split=new struct[counter];

        for (int j=0;j<counter;j++){
            avg[j]=new struct();
            split[j]=new struct();
        }
        
        for(int i=0;i<vec.size();i++){
            System.out.println(vec.size()+"  هنا  "+" "+ vec.get(i)+"    &&   "+getAvarage(vec.get(i))+"\n");
        avg[i].avarage=getAvarage(vec.get(i));
        split[i].obj=splitAvarage(avg[i].avarage); 
    }
         }
        if (counter==0){
        counter=(counter+2);
        }
        else{
            counter=counter*2;
        }
  System.out.println("I am in step 22");
  vec.clear();
  
for (int i=0;i<split.length;i++){
    System.out.println("I am in step 4");
    struct s[]=new struct[split[i].obj.size()];
   for (int t=0;t<counter;t++){
       s[t]=new struct();
   }
    for (int k=0;k<block.size();k++){
        System.out.println("I am in step 5");
        int index=compare(split[i].obj, block.get(k));
            s[index].obj.add(block.get(k));
        }
        for(int a=0;a<split[i].obj.size();a++){
            vec.add(a, s[a].obj);
        }
        for(int h=0;h<vec.size();h++){
            for (int t=0;t<vec.get(h).size();t++){
                for(int f=0;f<vec.get(h).get(t).size();f++){
                    System.out.println(vec.get(h).get(t).get(f));
                    
            }
                 System.out.println("**************");
        }

    
}
}
    }
}
public static void splitToBlock(int c,int r){
       int vectorsize=c*r;
       int countcol=0;
       int Pixelcounter=0;
       
    ArrayList<Integer>oneBlock=new ArrayList<>();
      for (int i=0;i<height;i=i+c){
          for (int j=0;j<width;j++){
            while(countcol<c){
                  oneBlock.add(pixel[i+countcol][j]);
                  countcol++;
                  Pixelcounter++;
            }
           countcol=0;
              if (Pixelcounter==vectorsize){
            block.add(oneBlock);
          
            oneBlock=new ArrayList<>();
            Pixelcounter=0;
             }
          }
    }
}
public static void printBlock(){
   for (int i=0;i<block.size();i++){
        for (int j=0;j<block.get(i).size();j++){
      System.out.print(block.get(i).get(j)+" ");
            if (j== block.get(i).size()-1){
                System.out.println();
            }
        }
    }
}
public static void print_images(){
   for (int i = 0; i < height-1; i++) {
            for (int j = 0; j < width-1; j++) {
        
                System.out.print(pixel[i][j]+" "); 
       
            }
            System.out.println(); 
        }
}
public static ArrayList<Float> getAvarage(ArrayList<ArrayList<Integer>>list){
   
	ArrayList<Float>avg=new ArrayList<>();
    float sum=0;
    
 System.out.println("list is  ::"+list+"\n");
 
 int sz1 = list.get(0).size();
 int sz2 = list.size();
 
    for (int i=0;i<sz1;i++){
        for (int j=0;j<sz2;j++){
            sum+=list.get(j).get(i);
        }
        sum=sum/list.size();
      
        avg.add(new  Float(sum));
        sum=0;
        
    }
/*  System.out.println(avg.get(0)+" "+avg.get(2));
     System.out.println(avg.get(1)+" "+avg.get(3));
    */
    
    return avg;
}
    public static int[][] readImage(String filePath,int col,int row) {
        File file = new File(filePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
      if ((height%2!=0&&(col%2)==0)||(height%2==0&&(col%2)!=0)){
         height=  height-1;
       }
      if ((width%2!=0&&(row%2)==0)||(width%2==0&&(row%2)!=0)){
         width=  width-1;
       }
      
      pixel = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
                int rgb = image.getRGB(j, i);
                int alpha = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = (rgb >> 0) & 0xff;

                pixel[i][j] = r;
      
                orginal.add(r);
            }
        }
        return pixel;
    }

    
    public static void main(String[] args) {
        Scanner cin=new Scanner (System.in);
        //   writeImage(pixel, "mohammed.jpg");  
        //   print_images();
        System.out.println("Enter  dimensions  ::\n");
        int col = cin.nextInt();
        int row = cin.nextInt();
        NumberOfBlokes = cin.nextInt();
        pixel=new int [6][6];
        height=6;
        width=6;
        System.out.println("Enter  Array  ::\n");
         for (int i = 0; i < 6; i++) {
            for (int j = 0; j <6; j++) {
                pixel[i][j]=cin.nextInt();
            }
            }
        //readImage("car.jpg",col,row);
      splitToBlock(col,row);
      System.out.println(block.size());
      printBlock();
      mainSplit(NumberOfBlokes);
    }
    /*
    1 2 7 9 4 11
    3 4 6 6 12 12
    4 9 15 14 9 9
    10 10 20 18 8 8
    4 3 17 16 1 4
    4 5 18 18 5 6
    */
}

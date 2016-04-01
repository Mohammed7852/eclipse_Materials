package VectorQuantization;

public class MaxError {

	private  float  MeanSquareError ;
	private  int ImageHighet , ImageWidth ;
	private  int  [][]MaxError; 
 
	public MaxError(int  h , int  w  ) {
		this.ImageHighet = h  ; 
		this.ImageWidth = w;
 	}
	
	public int[][] GetMaxError(){
		return MaxError ;
	}
	
	 public float Get_MSE(){
         return (MeanSquareError / (ImageHighet*ImageWidth)) ;
     }
	//****
	
	public void Caculate_Max_Error(int  [][]Origin , int  [][]Matrix){
        System.out.println("\n\tMaxError\n");
        MaxError = new  int  [ImageHighet][ImageWidth] ;
         MeanSquareError = 0 ;
        for(int  i=0 ;i<ImageHighet ;i++){
            for(int  j=0  ;j<ImageWidth ;j++){
                int Error  = Math.abs(Origin[i][j]-Matrix[i][j]);
                MaxError[i][j] = Error*Error ; 
                MeanSquareError += Error*Error ;
            }
        }
        
           System.out.print("\nSE="+MeanSquareError+"   , MQE="+(MeanSquareError/(ImageHighet*ImageWidth))+"\n\n");
    }

	

}

package first;
import  java.util.*;

public class HuffmanCode {
	 public float x;
	 public String str;
	public static void main(String[] args) {
	ArrayList<HuffmanCode> arr=new ArrayList<HuffmanCode>();
	HuffmanCode hf  = new HuffmanCode();
	         hf.str='a'+"";
	         hf.x=(float).17;
	         arr.add(hf);
	         
	        hf.str='b'+"";
	         hf.x=(float).23;
	        // arr.add(1, hf);
	         arr.add(hf);
	         
	        System.out.println(arr);
	        
	}
}

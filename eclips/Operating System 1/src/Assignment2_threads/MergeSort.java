package Assignment2_threads;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort {
    
    
    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        
        System.arraycopy(list, 0, first, 0, first.length);
       
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
    
    
    
       public static void main(String args[]) throws Exception
    {
        String list="";
         
        MergeSort s= new MergeSort();
        int  []arr  = {3,4,5,6,7,3,1,2,9,55,1,2,44};

        int  []first = new int [arr.length/2];
        int  []second = new  int [arr.length-first.length];
        
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second,0, second.length);
    
    //s.merge(first, second, result);
    
    
    }
}
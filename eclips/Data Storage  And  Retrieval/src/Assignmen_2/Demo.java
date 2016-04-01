package Assignmen_2;

import java.io.*;
import java.util.*;

import javax.swing.DefaultRowSorter;

public class Demo {

	static Scanner cin = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, IOException {

		int arr[] = { 3,4,6,2,9,4,7,8,6,5,3,1,2 };
		
 		BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
		for (int x  : arr){
			bw.write(x);
 		}
		bw.flush();
		bw.close();
		
		int K=2, runSize=2;
		String filename = "file.txt"/*"Data.bin"*/;
		
		System.out.println("Enter K-Merge:");
		K=cin.nextInt();
		
		System.out.println("Enter # RunSize :");
		runSize=cin.nextInt();
		
		
  		Merge merge  = new Merge();
		String  [] files  = merge.DivideInputFileIntoNRuns( filename,  K,  runSize);
		int  size= files.length;
		merge.SortEachRunOnMemoryAndWriteItBack(files);
		merge.DisplayRunsContent(files);
		String  outfile =merge.DoNWayMergeAndWriteASortedFile(files, "output.txt");
		int  index  = merge.BinarySearchOnSortedFile(outfile, 75);
		System.out.print("outputfile="+outfile+"\nindex="+index);
 
	}
}
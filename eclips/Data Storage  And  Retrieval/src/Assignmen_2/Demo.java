package Assignmen_2;

import java.io.*;
import java.util.*;
import javax.swing.DefaultRowSorter;

public class Demo {
	static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int K = 2, runSize = 2;
		String file1 = "file.txt", file2 = "Data.bin";
		String filename = file2;
		System.out.println("Enter K-Merge:");
		K = cin.nextInt();
		System.out.println("Enter # RunSize :");
		runSize = cin.nextInt();
		
		Merge merge = new Merge();
		String[] files = merge.DivideInputFileIntoNRuns(filename, K, runSize);// first
		int size = files.length;
		
		merge.SortEachRunOnMemoryAndWriteItBack(files);// second
		merge.DisplayRunsContent(files);
		String outfile = merge.DoNWayMergeAndWriteASortedFile(files, "output.txt");// third
		int searchvalue = 0;
		System.out.println("Enter value you want to Search for :");
		searchvalue = cin.nextInt();
		int index = merge.BinarySearchOnSortedFile("output.txt", searchvalue);// four
		if (index == -1) {
			System.out.println("The value :" + searchvalue + "  does not  exist.");
		}
		System.out.print("\nThe index of <" + searchvalue + ">  = " + index);
	}
}

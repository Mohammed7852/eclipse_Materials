package Assignmen_2;

import java.util.*;
import java.io.*;

public class Runs {
	public static void main(String[] args) throws IOException {
 		 System.out.println("\t\tMainMethod");
 		// RandomAccessFile Write = new RandomAccessFile("myfile.txt", "rw");
		// int arr[] = { 3,4,6,2,9,4,7,8,6,5,3,1,2 };
		// for(int x :arr)
		// Write.write(x);
		// Write.close();

		String file = "Data.bin";
		String file2 = "output.txt";
		RandomAccessFile Read = new RandomAccessFile(file2, "rw");
		Read.seek(0);
	   //System.out.println("length ="+Read.length()/4);
		int c = 0;
		for (int i = 0; i < Read.length() / 4; i++) {
			
			int num = Read.readInt();
			if (c == 10) {
				System.out.println();
				c = 0;
			}
			c++;
			System.out.print("" + num + ",");
		}
		Read.close();
	}

}

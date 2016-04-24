package Assignmen_2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Merge {

	private int K, runSize;
	String file_name;
	String[] files_name;
	private BufferedWriter writer1, writer2;
	private BufferedReader reader1, reader2;

	/**
	 * DivideInputFileIntoNRuns Method
	 * 
	 * @param Inputfilename
	 * @param k
	 * @param rSize
	 * @return
	 * @throws IOException
	 */
	public String[] DivideInputFileIntoNRuns(String Inputfilename, int k, int rSize) throws IOException {
		System.out.print("\n\t\tDivideInputFileIntoNRuns\n");
		this.K = k;
		this.runSize = rSize;
		this.file_name = Inputfilename;
		// --------------------------//
		String[] Array_files;
		// reader1 = new BufferedReader(new FileReader(file_name));
		RandomAccessFile Read = new RandomAccessFile(file_name, "r");
		Read.seek(0);
		int len = (int) Read.length() / 4;
		int countnums = 0;
		int count1 = 1, count2 = 0;
		List<String> filesName = new ArrayList();
		boolean temp = true;
		while (temp) {
			String filename = "Run#" + (count1++) + ".txt";
			System.out.print("\nat:" + filename + " will be :");
			// writer1 = new BufferedWriter(new FileWriter(filename));
			RandomAccessFile Write = new RandomAccessFile(filename, "rw");
			Write.seek(0);
			filesName.add(filename);
			int i = 0;
			for (; i < runSize; i++) {
				if (countnums >= len) {
					temp = false;
					break;
				}
				countnums++;
				int x = Read.readInt();
				System.out.print(x + ",");
				Write.writeInt(x);
			} // end for
			Write.close();
		} // end while
		Read.close();
		int size = count1 - 1;
		Array_files = new String[size];
		for (int i = 0; i < size; i++) {
			Array_files[i] = filesName.get(i);
		}
		return Array_files;
	}

	/**
	 * Sort method
	 * 
	 * @param list
	 * @return
	 */

	/**
	 * Sort Run
	 * 
	 * @param Runs
	 * @return
	 * @throws IOException
	 */

	public static void fnSortHeap(int array[], int arr_ubound) {

		int i, o;
		int lChild = 0, rChild = 0, mChild = 0, root = 0, temp = 0;
		root = (arr_ubound - 1) / 2;

		for (o = root; o >= 0; o--) {
			for (i = root; i >= 0; i--) {
				lChild = (2 * i) + 1;
				rChild = (2 * i) + 2;
				if ((lChild <= arr_ubound) && (rChild <= arr_ubound)) {
					if (array[rChild] >= array[lChild])
						mChild = rChild;
					else
						mChild = lChild;
				} else {
					if (rChild > arr_ubound)
						mChild = lChild;
					else
						mChild = rChild;
				}

				if (array[i] < array[mChild]) {
					temp = array[i];
					array[i] = array[mChild];
					array[mChild] = temp;
				}

			}
		}
		temp = array[0];
		array[0] = array[arr_ubound];
		array[arr_ubound] = temp;

		return;
	}

	/**
	 * Sort each Run
	 * 
	 * @param Runs
	 * @return
	 * @throws IOException
	 */
	public String[] SortEachRunOnMemoryAndWriteItBack(String[] Runs) throws IOException {
		System.out.println("\n\t\tSortEachRunOnMemoryAndWriteItBack");
		int size = Runs.length;
		for (String file : Runs) {
			// reader1 = new BufferedReader(new FileReader(file));
			RandomAccessFile Read = new RandomAccessFile(file, "r");
			Read.seek(0);
			int len = (int) Read.length() / 4;
			List<Integer> list = new ArrayList();
			for (int i = 0; i < len; i++) {
				list.add(Read.readInt());
			}
			Read.close();
			int sz = list.size();
			int arr[] = new int[sz];
			for (int i = 0; i < sz; i++)
				arr[i] = list.get(i);

			writer1 = new BufferedWriter(new FileWriter(file));
			RandomAccessFile Write = new RandomAccessFile(file, "rw");
			Write.seek(0);

			Collections.sort(list);
			System.out.println("Sorted List:" + list);
			for (int x : list)
				Write.writeInt(x);
			Write.close();
		}
		return Runs;
	}

	/**
	 * Display
	 * 
	 * @param Runs
	 * @throws IOException
	 */
	public void DisplayRunsContent(String[] Runs) throws IOException {
		System.out.println("\n\t\tDisplayRunsContent\n");
		int size = Runs.length;
		int count = 1;
		for (String file : Runs) {
			RandomAccessFile Read = new RandomAccessFile(file, "r");
			List<Integer> list = new ArrayList();
			int len = (int) Read.length();
			for (int i = 0; i < len / 4; i++) {
				list.add(Read.readInt());
			}
			Read.close();
			System.out.println("Run#=" + (count++) + "=" + list);
		}

	}//

	private int c = 1;

	/**
	 * Merge Method
	 * 
	 * @param Runs
	 * @param Outputfilename
	 * @return
	 * @throws IOException
	 */
	public String DoNWayMergeAndWriteASortedFile(String[] Runs, String Outputfilename) throws IOException {
		System.out.println("\t\tDoMerge");
		int size = Runs.length;
		if (size == 1) {
			RandomAccessFile Read = new RandomAccessFile(Runs[0], "r");
			RandomAccessFile write = new RandomAccessFile(Outputfilename, "rw");
			for (int i = 0; i < Read.length() / 4; i++) {
				write.writeInt(Read.readInt());
			}
			write.close();
			Read.close();
			System.out.println();
			return Runs[0];
		}
		boolean temp = true;
		int count1 = 0, count2 = 0;
		List<String> merged = new ArrayList();
		while (temp) {
			List<String> list = new ArrayList();
			for (int i = 0; i < K; i++) {
				if (count1 >= size)
					break;
				list.add(Runs[count1++]);
			}
			count2++;
			merged.add(merge(list));
			c++;
			if (count1 >= size)
				break;
		} // end while
		int sz = merged.size();
		String[] runs = new String[sz];
		for (int i = 0; i < sz; i++)
			runs[i] = merged.get(i);
		return DoNWayMergeAndWriteASortedFile(runs, Outputfilename);
	}

	/**
	 * Merge Function
	 * 
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public String merge(List<String> list) throws IOException {
		System.out.println("\t\tMerge");

		int size = list.size();
		System.out.println("\n\twe will merge  :" + size + "  files.");

		int count = 1;
		String str = "output" + c + "" + (count++) + ".txt";
		// Writer w = new BufferedWriter(new FileWriter(str));
		RandomAccessFile Write = new RandomAccessFile(str, "rw");
		Write.seek(0);
		RandomAccessFile[] ra = new RandomAccessFile[size];
		for (int i = 0; i < size; i++) {
			ra[i] = new RandomAccessFile(list.get(i), "rw");
			ra[i].seek(0);
		}
		// seek array holds number of seek reached in each file
		int[] seek = new int[size];
		String out = "";
		boolean temp = true;
		while (temp) {
			int counter = 0;
			int min = 0, index = 0;
			count = 0;

			for (int i = 0; i < size; i++) {
				int len = (int) ra[i].length() / 4;
				if (seek[i] < len) {
					ra[i].seek(seek[i] * 4);
					int x = ra[i].readInt();
					if (count == 0) {// this condition allows holding the first
										// element to be checked with others
						min = x;
						index = i;
						count++;
					} else {
						if (x < min) {
							min = x;
							index = i;
						}
					}
					counter++;
				}
			} // end for
			if (counter == 0)
				break;
			Write.writeInt(min);
			out += min + ",";
			seek[index]++;
		} // end while

		System.out.println("we write::" + out);
		Write.close();
		for (int i = 0; i < size; i++) {
			ra[i].close();
		} // end for

		return str;
	}

	/**
	 * + + ++++++++++++++++++++++++++++++++++++++++Binary Search
	 * 
	 * @param Sortedfilename
	 * @param SearchValue
	 * @return
	 * @throws IOException
	 */

	public int BinarySearchOnSortedFile(String Sortedfilename, int SearchValue) throws IOException {
		System.out.println("\t\tBinary Search");
		RandomAccessFile random = new RandomAccessFile(Sortedfilename, "r");
		random.seek(0);
		int mid, left, right;
		left = 0;
		right = (int) random.length() / 4;

		while (left <= right) {
			mid = (right + left) / 2;
			random.seek(mid*4);
			int value = random.readInt();
			if (value == SearchValue)
				return mid;
			if (value > SearchValue)
				right = mid - 1;
			if (value < SearchValue)
				left = mid + 1;
		} // end while
		random.close();

		return -1;
	}
}

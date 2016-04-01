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
		this.K = k;
		this.runSize = rSize;
		this.file_name = Inputfilename;
		// --------------------------//
		String[] Array_files;

		reader1 = new BufferedReader(new FileReader(file_name));
		int count1 = 1, count2 = 0;
		List<Integer> list = new ArrayList();
		List<String> filesName = new ArrayList();

		boolean temp = true;
		while (temp) {
			list = new ArrayList();
			int i = 0;
			for (; i < runSize; i++) {
				if (reader1.ready()) {
					int x = reader1.read();
					list.add(x);
				} else {
					temp = false;
					break;
				}
			} // end for

			String filename = "Run#" + (count1++) + ".txt";
			filesName.add(filename);
			System.out.println("at:" + filename + " will be :" + list);
			writer1 = new BufferedWriter(new FileWriter(filename));
			for (int y : list) {
				writer1.write(y);
			}
			writer1.flush();
			writer1.close();
		} // end while

		reader1.close();
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
	public List<Integer> sort(List<Integer> list) {

		int size = list.size();
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (list.get(j) < list.get(min))
					min = j;
			}
			int swap = list.get(i);
			list.set(i, list.get(min));
			list.set(min, swap);
		}

		return list;
	}

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
	 * @param Runs
	 * @return
	 * @throws IOException
	 */
	public String[] SortEachRunOnMemoryAndWriteItBack(String[] Runs) throws IOException {
		int size = Runs.length;
		for (String file : Runs) {
			reader1 = new BufferedReader(new FileReader(file));
			List<Integer> list = new ArrayList();
			while (reader1.ready()) {
				list.add(reader1.read());
			} // end while
			reader1.close();
			int sz = list.size();
			int arr[] = new int[sz];//this  array will holds  the  contents  of  the  list to be sorted
			for(int i = 0 ; i<sz ;i++)
				arr[i]=list.get(i);
				
			writer1 = new BufferedWriter(new FileWriter(file));

			for(int i=arr.length;i>1;i--)
			{
				fnSortHeap(arr, i-1);
 			}
			 for(int x :arr)
			 writer1.write(x);
			
			//Collections.sort(list);
			//list = sort(list);
			 
			System.out.println("Sorted List:"+list);
//			for(int x:list)
//			  writer1.write(x);
//			
			writer1.flush();
			writer1.close();
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
		int size = Runs.length;
		int count = 1;
		for (String file : Runs) {
			reader1 = new BufferedReader(new FileReader(file));
			List<Integer> list = new ArrayList();
			while (reader1.ready()) {
				list.add(reader1.read());
			} // end while
			reader1.close();
			System.out.println("Run#=" + (count++) + "=" + list);
		}

	}//

	private int c = 0;

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
			System.out.println("size=1,run[0]=" + Runs[0]);
			return Runs[0];
		}
 		boolean temp = true;
		int count1 = 0, count2 = 0;
		List<String> merged = new ArrayList();
 		while (temp) {
 			List<String> list = new ArrayList();
			for (int i = 0; i < K; i++) {
				list.add(Runs[count1++]);
				if (count1 >= size)
					break;
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
		System.out.println("size=" + size);
		int count = 1;
		String str = "output#" + c + "," + (count++) + ".txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(str));
		RandomAccessFile[] ra = new RandomAccessFile[size];
		for (int i = 0; i < size; i++) {
			ra[i] = new RandomAccessFile(list.get(i), "rw");
		}
		int[] seek = new int[size];
		String out = "";
		boolean temp = true;
		while (temp) {
			List<Integer> numbers = new ArrayList();
			List<Integer> indexes = new ArrayList();
			int counter = 0;
			for (int i = 0; i < size; i++) {
				int len = (int) ra[i].length();
				if (seek[i] < len) {
					ra[i].seek(seek[i]);
					int x = ra[i].read();
					numbers.add(x);
					indexes.add(i);
					counter++;
				}
			} // end for
			if (counter == 0)
				break;
			int min = numbers.get(0);
			int index = indexes.get(0);
			int sz = numbers.size();
			for (int i = 1; i < sz; i++) {
				int x = numbers.get(i);
				if (x < min) {
					min = x;
					index = i;
				}
			}

			w.write(min);
			out += min + ",";
			seek[index]++;
		} // end while

		System.out.println("we write::" + out);
		w.flush();
		w.close();
		for (int i = 0; i < size; i++) {
			ra[i].close();
		} // end for

		return str;
	}

	/**
	 * Binary Search
	 * 
	 * @param Sortedfilename
	 * @param SearchValue
	 * @return
	 * @throws IOException
	 */
	public int BinarySearchOnSortedFile(String Sortedfilename, int SearchValue) throws IOException {
		System.out.println("\t\tBinary Search ");
		RandomAccessFile random = new RandomAccessFile(Sortedfilename, "rw");
		int mid, left, right;
		mid = (int) random.length() / 2;
		left = 0;
		right = (int) random.length();

		while (left <= right) {
			mid = (right + left) / 2;
			random.seek(mid);
			int value = random.read();
			if (value > SearchValue)
				right = mid - 1;
			if (value < SearchValue)
				left = mid + 1;
			if (value == SearchValue)
				break;
		} // end while
		random.close();
		return mid;
	}
}

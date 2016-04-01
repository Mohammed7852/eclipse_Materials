package Lap6MemoryManagement;

import java.util.*;

public class MemorySimulator {
private final int MEMORY_SIZE = 50;
private final int FRAME_SIZE = 10;
private int clock=0;
private Hashtable<Integer, Page> pageTable = new Hashtable<Integer, Page>();
private List<Integer> freeFrames = new ArrayList<Integer>();
public MemorySimulator() {
for (int i = 0; i < getNumberOfFrames(); i++)
freeFrames.add(i);
}
private int getNumberOfFrames() {
return MEMORY_SIZE / FRAME_SIZE;
}
public Page leastRecentlyUsed(int pageNumber) {
int min = 10000;
int maxPageNumber = -1;
Iterator<Page> pageIterator = pageTable.values().iterator();
while (pageIterator.hasNext()) {
Page page = pageIterator.next();
if (min > page.getReferenceTime()) {
maxPageNumber = page.getPageNumber();
min = page.getReferenceTime();
}
}

return pageTable.get(maxPageNumber);
}
public void requestAddress(int address) {
//Increament the clock
clock++;
int pageNumber = address / FRAME_SIZE;
int offset = address % FRAME_SIZE;
Page page = pageTable.get(pageNumber);
int physicalAddress;
// Page is not in the memory
if (page == null) {
Page pagein = new Page();
pagein.setPageNumber(pageNumber);
// If no free frams Swap
if (freeFrames.size() == 0) {
Page pageOut = leastRecentlyUsed(pageNumber);
pagein.setPhysicalAddress(pageOut.getPhysicalAddress());
pagein.setReferenceTime(clock);
swap(pagein, pageOut);
} else {
//There are free frames no need for swap
int frameNumber = freeFrames.get(0);
pagein.setPageNumber(pageNumber);
pagein.setPhysicalAddress(frameNumber * FRAME_SIZE);
pagein.setReferenceTime(clock);
pageTable.put(pagein.getPageNumber(), pagein);
freeFrames.remove(0);
}

physicalAddress = pagein.getPhysicalAddress() + offset;
} else {
// Page in the memory just increament the refernce counter
page.setReferenceTime(clock);
physicalAddress = page.getPhysicalAddress() + offset;
}
System.out.println("Request Logical Address " + address + " Physical Address " + physicalAddress );
}

public void show() {
System.out.println("----------------------------------------");
Iterator<Page> pageIterator = pageTable.values().iterator();
while(pageIterator.hasNext())
{
Page page = pageIterator.next();
System.out.println("At " + page.getPhysicalAddress() + " Page Number: " + page.getPageNumber() + " Last Reference Time: " +
page.getReferenceTime());
}
System.out.println("----------------------------------------");
}
private void swap(Page pagein, Page pageOut) {
pageTable.remove(pageOut.getPageNumber());
System.out.println("Swap Out Page Number: " +
pageOut.getPageNumber());
pageTable.put(pagein.getPageNumber(), pagein);
System.out.println("Swap In Page Number: " +
pagein.getPageNumber());
}
public static void main(String[] args) {
	
		MemorySimulator memory = new MemorySimulator();
		memory.requestAddress(22);
		memory.show();
		memory.requestAddress(33);
		memory.show();
		memory.requestAddress(13);
		memory.show();
		memory.requestAddress(55);
		memory.show();
		memory.requestAddress(6);
		memory.show();
		memory.requestAddress(8);
		memory.show();
		memory.requestAddress(53);
		memory.show();
		memory.requestAddress(11);
		memory.show();
		memory.requestAddress(23);
		memory.show();
		memory.requestAddress(67);
		memory.show();
		}

}
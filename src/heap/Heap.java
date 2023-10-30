package heap;

import java.util.Arrays;

public class Heap {

	private int[] arr;
	private int maxSize, heapSize;

	public Heap(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.heapSize = 0;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	@Override
	public String toString() {
		return "Heap [arr=" + Arrays.toString(arr) + ", maxSize=" + maxSize + ", heapSize=" + heapSize + "]";
	}

}

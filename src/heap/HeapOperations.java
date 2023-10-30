package heap;

public class HeapOperations {

	public static void main(String[] args) {
		
		Heap h = new Heap(10);
		h = insertKeyMaxHeap(h, 1);
		h = insertKeyMaxHeap(h, 5);
		h = insertKeyMaxHeap(h, 3);
		h = insertKeyMaxHeap(h, 7);
		h = insertKeyMaxHeap(h, 11);
		h = insertKeyMaxHeap(h, 8);
		h = insertKeyMaxHeap(h, 15);
		System.out.println(h.toString());
		
		for(int i=0; i<10; i++) {
			h = removeMaxHeap(h);
		}

	}
	
	public static Heap removeMaxHeap(Heap h) {
		int heapSize = h.getHeapSize();
		int[] arr = h.getArr();

		if (heapSize <= 0) {
			System.out.println("Heap already empty");
			return h;
		} else if (heapSize == 1) {
			System.out.print("Removed element - " + arr[0]);
			arr[0] = 0;
			h.setArr(arr);
			h.setHeapSize(--heapSize);
			System.out.println("\t"+h);
			return h;
		}

		System.out.print("Removed element - " + arr[0]);
		arr[0] = arr[heapSize - 1];
		arr[heapSize - 1] = 0;
		h.setArr(arr);
		h.setHeapSize(--heapSize);

		h = maxHeapify(h, 0);
		System.out.println("\t"+h);

		return h;
	}
	
	public static int removeMinHeap(Heap h) {
		int heapSize = h.getHeapSize();
		int[] arr = h.getArr();
		int del = -1;

		if (heapSize <= 0) {
			System.out.println("Heap already empty");
			return del;
		} else if (heapSize == 1) {
//			System.out.print("Removed element - " + arr[0]);
			del = arr[0];
			arr[0] = 0;
			h.setArr(arr);
			h.setHeapSize(--heapSize);
//			System.out.println("\t"+h);
			return del;
		}

//		System.out.print("Removed element - " + arr[0]);
		del = arr[0];
		arr[0] = arr[heapSize - 1];
		arr[heapSize - 1] = 0;
		h.setArr(arr);
		h.setHeapSize(--heapSize);

		h = minHeapify(h, 0);
//		System.out.println("\t"+h);

		return del;
	}

	public static Heap insertKeyMaxHeap(Heap h, int key) {
		int maxSize = h.getMaxSize(), heapSize = h.getHeapSize();
		int[] arr = h.getArr();
		
		if(heapSize == maxSize) {
			System.out.println("\nOverflow: Could not insertKey\n");
			return h;
		}
		h.setHeapSize(++heapSize);
		int i = heapSize -1;
		arr[i] = key;
		
		while(i!=0 && arr[parent(i)] < arr[i]) {
			arr = swap(arr, i, parent(i));
			i = parent(i);
		}
		h.setArr(arr);
		
		return h;
	}
	
	public static Heap insertKeyMinHeap(Heap h, int key) {
		int maxSize = h.getMaxSize(), heapSize = h.getHeapSize();
		int[] arr = h.getArr();
		
		if(heapSize == maxSize) {
			System.out.println("\nOverflow: Could not insertKey\n");
			return h;
		}
		h.setHeapSize(++heapSize);
		int i = heapSize -1;
		arr[i] = key;
		
		while(i!=0 && arr[parent(i)] > arr[i]) {
			arr = swap(arr, i, parent(i));
			i = parent(i);
		}
		h.setArr(arr);
		
		return h;
	}
	
	public static Heap maxHeapify(Heap h, int i) {
		int heapSize = h.getHeapSize();
		int[] arr = h.getArr();

		int l = lChild(i), r = rChild(i), largest = i;
		if (l < heapSize && arr[l] > arr[largest])
			largest = l;
		if (r < heapSize && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			arr = swap(arr, i, largest);
			h.setArr(arr);
			h = maxHeapify(h, largest);
		}

		return h;
	}
	
	public static Heap minHeapify(Heap h, int i) {
		int heapSize = h.getHeapSize();
		int[] arr = h.getArr();

		int l = lChild(i), r = rChild(i), smallest = i;
		if (l < heapSize && arr[l] < arr[smallest])
			smallest = l;
		if (r < heapSize && arr[r] < arr[smallest])
			smallest = r;

		if (smallest != i) {
			arr = swap(arr, i, smallest);
			h.setArr(arr);
			h = minHeapify(h, smallest);
		}

		return h;
	}
	
	public static int parent(int index) {
		return (index - 1) / 2;
	}

	public static int lChild(int index) {
		return (2 * index + 1);
	}

	public static int rChild(int index) {
		return (2 * index + 2);
	}

	public static int[] swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
		return arr;
	}

}

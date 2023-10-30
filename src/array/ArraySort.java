package array;

import heap.HeapOperations;

public class ArraySort {

	public static void main(String[] args) {
		
//		int arr[] = new int[] { 1, 6, 3, 8, 23, 78, 45, 17, 50, 13, 97, 146, 78, 99, 786, 138 };
//		int arr[] = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		int[] arr = new int[100001];
		for(int i=0; i<=100000 ; i++) {
			arr[i] = 100000 -i;
		}
		

		
//		int bubbleSort[] = bubbleSort(arr, arr.length);
//
//
//		int selectionSort[] = selectionSort(arr, arr.length);
//
//		int mergeSort[] = mergeSort(arr, 0, arr.length - 1);
//
//		int insertionSort[] = insertionSort(arr, arr.length);
//
//		int quickSort[] = quickSort(arr, 0, arr.length - 1);
		
		long before = System.currentTimeMillis();
//		int heapSort[] = heapSort(arr);
		int heapSort[] = heapSort(arr);
		long after = System.currentTimeMillis();


		printArray(heapSort);
		System.out.println(after-before);

		

	}
	
	public static int[] heapSort(int arr[]) {
		int n = arr.length;

		// Call heapify for all internal node since all leaf nodes are already heap
		// in heap, internal(non-leaf) nodes range from index 0 to (n-1)/2
		for (int i = (n - 1) / 2; i >= 0; i--) {
			heapify(arr, i, n);
		}

		// Remove topmost greatest element and place it at the end of array and call heapify for the reduced array
		for (int i = n - 1; i > 0; i--) {
			arr = HeapOperations.swap(arr, 0, i);
			heapify(arr, 0, i);
		}

		return arr;
	}

	public static void heapify(int[] arr, int i, int n) {

		int l = 2 * i + 1, r = 2 * i + 2, largest = i;

		if (l < n && arr[l] > arr[largest])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			arr = HeapOperations.swap(arr, i, largest);
			heapify(arr, largest, n);
		}

	}

	private static int[] quickSort(int[] arr, int l, int h) {

		if (l < h) {
			// Find the pivot and place it at correct location - all elements to left of
			// pivot as small and vice versa
			int j = partition(arr, l, h);

			// Recursively use it for smaller partitions
			arr = quickSort(arr, l, j - 1);
			arr = quickSort(arr, j + 1, h);
		}

		return arr;
	}

	private static int partition(int[] arr, int l, int h) {

		// Last element as pivot
		int pivot = arr[h];
		// i denotes the position just to the left of pivot
		int i = l - 1;

		// traverse array from low to high-1 (since high = pivot)
		for (int j = l; j <= h - 1; j++) {
			// pick smaller elements and put to the left of pivot
			if (arr[j] < pivot) {
				++i;
				arr = swap(arr, i, j);
			}
		}

		// finally place the pivot at right location - just to the right of all the
		// smalller elements
		arr = swap(arr, i + 1, h);

		return i + 1;
	}

	private static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	private static int[] insertionSort(int[] arr, int n) {

		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				--j;
			}
			arr[j + 1] = key;
		}

		return arr;
	}

	private static int[] mergeSort(int[] arr, int l, int r) {

		if (l < r) {
			int m = l + (r - l) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);

		}

		return arr;
	}

	private static void merge(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		int i = 0, j = 0, k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				++i;
			} else {
				arr[k] = R[j];
				++j;
			}
			++k;
		}

		while (i < n1) {
			arr[k] = L[i];
			++i;
			++k;
		}
		while (j < n2) {
			arr[k] = R[j];
			++j;
			++k;
		}

	}

	private static int[] bubbleSort(int[] arr, int n) {
		boolean swap;
		for (int i = 0; i < n; i++) {
			swap = false;
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					arr = swap(arr, j, j+1);
					swap = true;
				}
			}

			if (!swap) {
				break;
			}
		}

		return arr;
	}

	// Iterates over the array
	// Selects the smallest number and places it at the beginning
	// Iterates over the rest of the array
	private static int[] selectionSort(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int minIndex = i;
			int minVal = arr[i];
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < minVal) {
					minIndex = j;
					minVal = arr[j];
				}
			}
			arr = swap(arr, i, minIndex);
		}

		return arr;
	}

	private static void printArray(int[] array) {

		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}

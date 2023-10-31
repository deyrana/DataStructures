package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ArrayPractice {

	public static void main(String[] args) {
//		int[] arr = new int[] { 90, 70, 20, 80, 50 };
//		int revArr[] = reverseArray(arr, arr.length);
//		
//		for (int i : revArr) {
//			System.out.println(i);
//		}

//		findAllPossibleArray(arr, arr.length);
//		printSubArrays(arr, 0, 0);
		long[] arr = new long []{1,2,3};
		System.out.println(minCost(arr, 3));

	}
	
	static long minCost(long arr[], int n) 
    {
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for(int i = 0; i< n; i++) {
			pq.add(arr[i]);
		}
		long cost = 0;
		while(pq.size() > 1) {
			long sum = pq.poll() + pq.poll();
			cost += sum;
			pq.add(sum);
		}
        return cost;
    }

	static void printSubArrays(int[] arr, int start, int end) {
		// Stop if we have reached the end of the array
		if (end == arr.length)
			return;
		// Increment the end point and start from 0
		else if (start > end)
			printSubArrays(arr, 0, end + 1);
		// Print the subarray and increment the starting
		// point
		else {
			System.out.print("[");
			for (int i = start; i < end; i++)
				System.out.print(arr[i] + ", ");
			System.out.println(arr[end] + "]");
			printSubArrays(arr, start + 1, end);
		}
		return;
	}

	private static void findAllPossibleArray(int[] arr, int length) {
		int l = 0, h = length - 1;

		findArray(arr, l, h);

	}

	private static void findArray(int[] arr, int l, int h) {

		if (l > h)
			return;
		printArrayltoh(arr, l, h);

		findArray(arr, l, h - 1);
		findArray(arr, l + 1, h);

	}

	private static void printArrayltoh(int[] arr, int l, int h) {

		for (int i = l; i <= h; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	private static int[] reverseArray(int[] arr, int length) {
		int temp[] = arr.clone();
		for (int i = 0; i < length; i++) {
			arr[i] = temp[length - i - 1];
		}
		return arr;
	}

	public static boolean findPair(int arr[], int size, int n) {
		Arrays.sort(arr);

		return findPairRec(arr, 0, size - 1, size, n);

	}

	private static boolean findPairRec(int[] arr, int l, int r, int size, int target) {
		if (l >= r)
			return false;

		if (arr[r] - arr[l] == target) {
//			System.out.println("r - "+r+" l - "+l);
			return true;
		}

		return findPairRec(arr, l, r - 1, size - 1, target) || findPairRec(arr, l + 1, r, size - 1, target);

	}

	public static int closestToZero(int arr[], int n) {
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (Math.abs(arr[i] + arr[j]) < Math.abs(minSum)) {
						minSum = arr[i] + arr[j];
					}
				}
			}
		}

		return minSum;
	}

	private static int findRepeatElement(int[] arr, int n) {
		HashMap<Integer, ElmData> map = new HashMap();

		for (int i = 0; i < n; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], new ElmData(1, i));
			} else {
				ElmData ed = map.get(arr[i]);
				ed.setCount(ed.getCount() + 1);
				map.put(arr[i], ed);
			}
		}

		System.out.println(map.toString());
		int smallInd = n;
		for (HashMap.Entry<Integer, ElmData> entry : map.entrySet()) {
			if (entry.getValue().getCount() > 1 && entry.getValue().getIndex() < smallInd) {
				smallInd = entry.getValue().getIndex();
			}
		}

		if (smallInd == n)
			return -1;
		return arr[smallInd];
	}

	static class ElmData {
		int count;
		int index;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public ElmData(int count, int index) {
			super();
			this.count = count;
			this.index = index;
		}

		@Override
		public String toString() {
			return "ElmData [count=" + count + ", index=" + index + "]";
		}

	}

	private static void find3largestNum(int[] arr) {
		int l1 = 0, l2 = 0, l3 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > l1) {
				l3 = l2;
				l2 = l1;
				l1 = arr[i];
			} else if (arr[i] <= l1 && arr[i] > l2) {
				l3 = l2;
				l2 = arr[i];
			} else if (arr[i] <= l1 && arr[i] <= l2 && arr[i] > l3) {
				l3 = arr[i];
			}
		}
		System.out.println("3 biggest numbers are - " + l1 + " " + l2 + " " + l3);

	}

}

package array;

public class ArraySearch {	
	
	static int[] arr = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
	
	public static void main(String[] args) {
//		System.out.println(binarySearch(arr, 0, arr.length-1, 91));
//		System.out.println(ternarySearch(arr, 0, arr.length-1, 91));
		int target = 9;
		int block = (int) Math.floor(Math.sqrt(arr.length));
		if(jumpSearch(arr, block, target) != -1)
			System.out.println("Found "+target);
		else
			System.out.println("Not Found "+target);
	}
	
	private static int jumpSearch(int[] arr, int block, int target) {
		
		int m = 0;
		while(m<arr.length) {
			if(arr[m]==target)
				return m;
			else if(arr[m] < target)
				m += block;
			else {
				break;
			}
		}
		int n = m-block+1;
		for(int i=n; i<arr.length;i++) {
			if(arr[i]==target)
				return i;
		}
		
		return -1;
	}
	
	private static int ternarySearch(int[] arr, int l, int r, int target) {
		
		if(r<l)
			return -1;
		
		int mid1 = l + (r-l)/3;
		int mid2 = r - (r-l)/3;
		
		System.out.print("Mid1 - "+mid1+" Mid2 - "+mid2);
		System.out.println();
		
		if(arr[mid1] == target)
			return mid1;
		else if(arr[mid2] == target)
			return mid2;
		else if(arr[mid1] > target)
			return ternarySearch(arr, l, mid1-1, target);
		else if(arr[mid2] < target)
			return ternarySearch(arr, mid2+1, r, target);
		else
			return ternarySearch(arr, mid1+1, mid2-1, target);
	}

	public static int binarySearch(int[] arr, int l, int r, int target) {
		if(r<l)
			return -1;
		int mid = l + (r-l)/2;
		
		if(arr[mid] == target)
			return mid;
		else if(arr[mid] > target)
			return binarySearch(arr, l, mid-1, target);
		else
			return binarySearch(arr, mid+1, r, target);
	}
	
	

}

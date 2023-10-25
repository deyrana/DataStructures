package array;

public class ArrayIntro {

	// Creation of an Array reference
	static int[] arr;

	public static void main(String[] args) {
//		initializeArray();
		
		int[] arr = new int[20];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;
		arr[7] = 8;
		arr[8] = 9;
		arr[9] = 10;
		
		
		arr = insertAtPos(arr, 10, 14, 23);
		printArray(arr);
		
	}
	
	private static void printArray(int[] array) {

		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static int[] insertAtPos(int[] arr, int length, int pos, int target) {
		
		
		for(int i=length-1; i>=pos-1; i--) {
			arr[i+1] = arr[i];
		}
		arr[pos-1] = target;
		
		return arr;
	}

	public static void initializeArray() {
		// Array instantiating
//		arr = new int[5];

//		arr = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println("Array length - " + arr.length);

//		Student[] st = new Student[5];
//		for (int i = 0; i < st.length; i++) {
//			st[i] = new Student(i, "StudentNo" + i);
//		}
//
//		for (int i = 0; i < st.length; i++) {
//			System.out.println(st[i].getName() + " " + st[i].getRoll_no());
//		}
//		
//		System.out.println(st[10]);
		
		int n = 3;
		int [][] arr2d = new int[n][n];
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				arr2d[i][j] = i+j;
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				 System.out.print(arr2d[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(arr2d.getClass());
		String [] sar = new String[] {"rana"};
		System.out.println(sar.getClass().getSuperclass());
	}

	static class Student {
		public int roll_no;
		public String name;

		Student(int roll_no, String name) {
			this.roll_no = roll_no;
			this.name = name;
		}

		public int getRoll_no() {
			return roll_no;
		}

		public void setRoll_no(int roll_no) {
			this.roll_no = roll_no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}

}

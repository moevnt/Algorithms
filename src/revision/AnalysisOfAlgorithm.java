package revision;

public class AnalysisOfAlgorithm {


	public static void main(String[] args){
		int[] n = {4,3,2,1,-1,-2,-3,-4};

		double time = System.currentTimeMillis();
		display(Algorithm1(n));
		display(Algorithm2(n));
		display(Algorithm3(n));

		System.out.println(System.currentTimeMillis()-time);
	}

	private static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static int[] Algorithm1(int[] arr){
		int[] n = new int[arr.length];
		int count=0;

		for (int i=0; i<arr.length;i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i] + arr[j] == 0) { //if the addition of the positive integer and the negative integer results in a 0, they have the same absolute value. return true
					n[count] = Math.abs(arr[i]);
					count++;
				}
			}
		}
		return n;
	}

	public static int[] Algorithm2(int[] arr){
		int[] n = new int[arr.length];
		int count=0;
		for (int i=0; i<arr.length; i++)
			if (binarySearch(arr, arr[i]))
				n[count++] = Math.abs(arr[i]);
		return n;
	}

	private static boolean binarySearch(int[] arr, int key){
		int high = arr.length-1;
		int low = 0;

		return binarySearch(arr, key, high, low);
	}

	private static boolean binarySearch(int[] arr, int key, int high, int low){
		if(low>high)
			return false;
		int mid = (high + low)/2;

		if (arr[mid] + key == 0)
			return true;

		else if (arr[mid] + key > 0){
			return binarySearch(arr, key, high,mid+1);
		}
		else
			return binarySearch(arr, key, mid-1, low);
	}

	public static int[] Algorithm3(int[] arr){
		int i = 0;
		int j = arr.length-1;
		int[] n = new int[arr.length];
		int count=0;

		for (int k=0; k<arr.length/2;k++){
			if(arr[i] + arr[j] == 0)
				n[count++] = Math.abs(arr[i]);
			i++;
			j--;
		}
		return n;
	}

}

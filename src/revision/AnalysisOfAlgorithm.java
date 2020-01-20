package revision;

public class AnalysisOfAlgorithm {


	public static void main(String[] args){
		int[] n = {6,4,2,1,-3,-5,-7};

		System.out.println(Algorithm1(n));
		System.out.println(Algorithm2(n));
		System.out.println(Algorithm3(n));
	}

	public static boolean Algorithm1(int[] arr){	//sequential search-runs through each possible combination runs in n^2, possibly moved to n.
		for (int i=0; i<arr.length;i++){
			for(int j=0; j<arr.length; j++){
				if(arr[j]+arr[i] == 0) //if the addition of the positive integer and the negative integer results in a 0, they have the same absolute value. return true
					return true;
			}
		}
		return false;
	}

	public static boolean Algorithm2(int[] arr){

		for (int i=0; i<arr.length; i++)
			if (binarySearch(arr, arr[i]))
				return true;

		return false;

	}

	public static boolean Algorithm3(int[] arr){
		int i = 0;
		int j = arr.length-1;

		for (int k=0; k<arr.length/2;k++){
			if(arr[i] + arr[j] == 0)
				return true;
			i++;
			j--;
		}
		return false;
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



}

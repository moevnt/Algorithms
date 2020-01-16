package revision;

public class AnalysisOfAlgorithm {
	int[] n = {6,4,2,-1,-2,-3,-5};

	public static void main(String[] args){
		int[] n = {6,4,2,1,-1,-3,-5,-7};

		System.out.println(Algorithm1(n));
	}

	public static boolean Algorithm1(int[] arr){
		for (int i=0; i<arr.length;i++){
			for(int j=0; j<arr.length; j++){
				if(arr[j]+arr[i] == 0)
					return true;
			}
		}
		return false;
	}

	public static boolean Algorithm2(int[] arr){
		
	}
}

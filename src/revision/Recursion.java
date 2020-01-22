package revision;

public class Recursion {
	private static int[] x;
	private static int count =0;

	public static void main(String[] args){
		int[][] n = new int[3][3];

		n[0][0] = 97;
		n[0][1] = 47;
		n[0][2] = 56;
		n[1][0] = 35;
		n[1][1] = 57;
		n[1][2] = 41;
		n[2][0] = 89;
		n[2][1] = 36;
		n[2][2] = 98;

		display(n);

		int[] results = findPath(n, 0,0 );

		for (int i=0;i<results.length;i++){
			System.out.println(results[i]);
		}
	}

	public static int[] findPath(int[][] n, int r, int c){
		int[] surroundings = checkSurrounding(n,r,c);
		int high = findHigh(surroundings);

		if (high > n[r][c])
			return x;

		else {
			x[count] = high;
			return x;
		}
	}

	private static int findHigh(int[] n){
		int high = Integer.MIN_VALUE;
		for (int i=0;i<n.length;i++){
			if (n[i]<high)
				high = n[i];
		}
		return high;
	}

	public static int[] checkSurrounding(int[][] n, int r, int c){
		//up, down, left, right, uL, uR, dL, dR
		int test[] = new int[8];
		if(r < n.length-1){
			test[1] = n[r+1][c];

			if(c < n[r].length)
				test[7] = n[r+1][c+1];

			if(c > 0)
				test[6] = n[r+1][c-1];
		}
		if(r > 0){
			test[0] = n[r-1][c];

			if(c < n[r].length)
				test[5] = n[r-1][c+1];

			if(c > 0)
				test[4] = n[r-1][c-1];
		}

		if(c > 0)
			test[2] = n[r][c-1];
		if(c < n[r].length)
			test[3] = n[r][c+1];
		/*
		System.out.println(up);
		System.out.println(down);
		System.out.println(left);
		System.out.println(right);
		System.out.println(uL);
		System.out.println(uR);
		System.out.println(dL);
		System.out.println(dR);
		*/

		return test;
	}

	public static void display(int[][] n){
		for(int r=0;r<n.length;r++){
			for(int c=0;c<n[0].length;c++){
				System.out.print(n[r][c]+"\t");
			}
			System.out.println();
		}
	}

}

//used GeeksForGeeks to initialize multidimensional arrays

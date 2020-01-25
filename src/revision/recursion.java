package revision;

public class recursion {

		private static Unit[] x = new Unit[9];
		private static int count =0;

		public static void main(String[] args){
			Unit[][] n = new Unit[3][3];

			n[0][0] = new Unit(97,0,0);
			n[0][1] = new Unit(47,0,1);
			n[0][2] = new Unit(56,0,2);
			n[1][0] = new Unit(35,1,0);
			n[1][1] = new Unit(57,1,1);
			n[1][2] = new Unit(41,1,2);
			n[2][0] = new Unit(89,2,0);
			n[2][1] = new Unit(36,2,1);
			n[2][2] = new Unit(98,2,2);

			display(n);


			Unit[] results = findPath(n, 0,0);

			for (int i=0;i<results.length;i++){
				if(results[i] != null)
					System.out.println(results[i].getNumber());
			}
		}

		public static Unit[] findPath(Unit[][] n, int r, int c){
			Unit[] surr = checkSurrounding(n,r,c);
			Unit[] output = new Unit[n.length];
			int count=0;

			for (int i=0;i<surr.length;i++){
				if(surr[i] != null && surr[i].getNumber() < n[r][c].getNumber()){
					output[count++] = surr[i];
					findPath(n, surr[i].getR(),surr[i].getC(),output, count);
				}
			}

			if (r == n.length-1 && c == n[r].length-1)
				return output;
			else if(r == n.length)
				return findPath(n,r+1,c);
			else
				return findPath(n,r,c+1);
		}

	public static Unit[] findPath(Unit[][] n, int r, int c, Unit[] output, int count){
		Unit[] surr = checkSurrounding(n,r,c);


		for (int i=0;i<surr.length;i++){
			if(surr[i] != null && surr[i].getNumber() < n[r][c].getNumber()){
				output[count++] = surr[i];
				findPath(n, surr[i].getR(),surr[i].getC(),output, count);
			}
		}

		if (r == n.length-1 && c == n[r].length-1)
			return output;
		else if(r == n.length)
			return findPath(n,r+1,c);
		else
			return findPath(n,r,c+1);

	}

		private static int findHigh(int[] n){
			int high = Integer.MIN_VALUE;
			for (int i=0;i<n.length;i++){
				if (n[i]<high)
					high = n[i];
			}
			return high;
		}

		public static Unit[] checkSurrounding(Unit[][] n, int r, int c){
			//up, down, left, right, uL, uR, dL, dR
			Unit test[] = new Unit[8];
			if(r < n.length-1){
				test[1] = new Unit(n[r+1][c].getNumber(),r+1,c);

				if(c < n[r].length)
					test[7] = new Unit(n[r+1][c+1].getNumber(),r+1,c+1);

				if(c > 0)
					test[6] = new Unit(n[r+1][c-1].getNumber(),r+1,c-1);
			}
			if(r > 0){
				test[0] = new Unit(n[r-1][c].getNumber(),r-1,c);

				if(c < n[r].length)
					test[5] = new Unit(n[r-1][c+1].getNumber(),r-1,c+1);

				if(c > 0)
					test[4] = new Unit(n[r-1][c-1].getNumber(),r-1,c-1);
			}

			if(c > 0)
				test[2] = new Unit(n[r][c-1].getNumber(),r,c-1);
			if(c < n[r].length)
				test[3] = new Unit(n[r][c+1].getNumber(),r,c+1);

			return test;
		}

		public static void display(Unit[][] n){
			for(int r=0;r<n.length;r++){
				for(int c=0;c<n[0].length;c++){
					System.out.print(n[r][c].getNumber()+"\t");
				}
				System.out.println();
			}
		}


}

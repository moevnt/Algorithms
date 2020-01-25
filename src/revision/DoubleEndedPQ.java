package revision;

public class DoubleEndedPQ {

	private int[] queue;
	public static final int QUEUE_SIZE =20;

	private int front;
	private int back;
	private int size;

	public DoubleEndedPQ(){
		queue = new int[QUEUE_SIZE];

	}

	public void makeEmpty(){
		front = 0;
		back = -1;
		size = 0;
	}

	public int findMin(){
		return queue[front];
	}

	public int findMax(){
		return queue[back-1];
	}

	public void deleteMax(){
		queue[back-1] = 0;
		back--;
		size--;
	}

	public void deleteMin(){
		queue[front] = 0;
		front++;
		size--;
	}

	public void insert(int n){

		back = increment(back);

		if(size == 0)
			queue[front] = n;

		else if(queue[back-size] < n){
			queue[back-1] = n;

		}

		else{
			int temp;
			for(int i=front;i<size;i++){
				if(queue[i] > n){
					temp = queue[i];
					queue[i] = n;
					n = temp;

					if (queue[i] < n)
						queue[back-1] = n;
				}

			}
		}

		size = increment(size);
	}

	public int increment(int x){
		if(++x == queue.length)
			x=0;
		return x;
	}

	public void display(){
		for (int i=0;i<size;i++){
			System.out.print(queue[front+i]+",");
		}
		System.out.println();
	}

	public static void main(String[] args){
		DoubleEndedPQ pq = new DoubleEndedPQ();

		for (int i=1;i<QUEUE_SIZE;i++) {
			pq.insert(i);
		}

		pq.display();
		pq.findMin();
		pq.findMax();
		pq.deleteMin();
		pq.deleteMax();
		pq.display();


	}


}

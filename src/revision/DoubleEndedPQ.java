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

	public void insert(int n){
		back = increment(back);
		System.out.println(back);

		if(size == 0) {
			queue[front] = n;
		}

		else {
			int temp;
			for (int i = front; i < size-1; i++) {
				if (queue[i] > n) {
					temp = queue[i];
					queue[i] = n;
					n = temp;
				}
			}
		}
		size++;
		System.out.println(size);
	}

	public int increment(int x){
		if(++x == queue.length)
			x=0;
		return x;
	}

	public void display(){
		for (int i=0;i<queue.length;i++){
			System.out.print(queue[i]+",");
		}
	}

	public static void main(String[] args){
		DoubleEndedPQ pq = new DoubleEndedPQ();

		pq.insert(10);
		pq.insert(9);
		pq.display();
	}


}

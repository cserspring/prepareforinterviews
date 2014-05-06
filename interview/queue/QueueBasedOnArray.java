package queue;

public class QueueBasedOnArray {
	private int MAX_SIZE;
	private int[] arr;
	private int count;
	private int front;

	public QueueBasedOnArray(int n) {
		this.MAX_SIZE = n;
		this.arr = new int[n];
		this.count = 0;
		this.front = 0;
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public boolean isFull() {
		return this.count == this.MAX_SIZE;
	}

	public void enqueue(int val) {
		arr[(front + count) % MAX_SIZE] = val;
		++count;
	}

	public int dequeue() {
		int val = arr[front];
		front = (front + 1) % MAX_SIZE;
		--count;
		return val;
	}

	public static void main(String[] args) {
		QueueBasedOnArray q = new QueueBasedOnArray(5);
		int i = 0;
		while (!q.isFull()) {
			q.enqueue(++i);
		}
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}
}

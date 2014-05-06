package queue;

import java.util.Stack;

public class QueueBasedOnStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueBasedOnStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty())
			return true;
		return false;
	}

	public void enqueue(int val) {
		stack1.push(val);
	}

	public int dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueBasedOnStack q = new QueueBasedOnStack();
		int i = 0;
		while (i < 5) {
			q.enqueue(i++);
		}
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println("*********");
		while (i < 10) {
			q.enqueue(i++);
		}
		while (!q.isEmpty())
			System.out.println(q.dequeue());
	}
}

public class Queue<T> {
	private int capacity;
	private T[] array;
	private int front, rear;
	private int length;

	public Queue(int capacity) {
		if (capacity <= 0) throw new IllegalArgumentException("must be greater than 0");
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
		rear = -1;
	}

	public Queue() {
		this(10);
	}

	public void enqueue(T element) {
		if (isFull()) throw new RuntimeException("Queue is full");
		rear = (rear + 1) % capacity;
		array[rear] = element;
		length++;
	}

	public T dequeue() {
		if (isEmpty()) throw new RuntimeException("Queue already empty");
		T element = array[front];
		front = (front + 1) % capacity;
		length--;
		return element;
	}

	public T peek() {
		if (isEmpty()) throw new RuntimeException("Queue is empty");
		return array[front];
	}

	public int size() {
		return length;
	}

	public boolean isFull() {
		return size() == capacity;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
}
public class Stack {
	private int capacity, size;
	private int stackTop = -1;
	private int[] internalArray;

	public Stack(int capacity) {
		this.capacity = capacity;
		internalArray = new int[capacity];
	}

	public void push(int element) {
		internalArray[++stackTop] = element;
		size++;
	}

	public int pop() {
		int poppedElement = internalArray[stackTop];
		stackTop--;
		size--;
		return poppedElement;
	}

	public int peek() {
		return internalArray[stackTop];
	}

	public int size() {
		return size;
	}

	public void printStack() {
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(internalArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(13);
		stack.push(36);
		System.out.print("Stack => ");
		stack.printStack();
		System.out.println("\nStack peek => " + stack.peek());
		System.out.println("Stack pop => " + stack.pop());
		stack.push(83);
		stack.push(48);
		System.out.print("Stack => ");
		stack.printStack();
		System.out.println("\nStack size => " + stack.size());
	}
}
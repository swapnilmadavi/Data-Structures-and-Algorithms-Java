public class QueueTester {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>(3);
		
		System.out.println("Queue initialize => 12 7");
		queue.enqueue(12);
		queue.enqueue(7);
		
		System.out.println("Queue size => " + queue.size());
		System.out.println("Queue front => " + queue.peek());
		System.out.println("Queue dequeue => " + queue.dequeue());
		
		System.out.println("Queue enqueue 29");
		queue.enqueue(29);
		
		System.out.println("Queue enqueue 41");
		queue.enqueue(41);
		
		System.out.println("Queue size => " + queue.size());
		System.out.println("Queue front => " + queue.peek());
		
		System.out.println("Trying to enqueue 38 in an already full queue; should throw an Exception");
		queue.enqueue(38);
	}
}
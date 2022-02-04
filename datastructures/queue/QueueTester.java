import java.util.StringJoiner;

public class QueueTester {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(4);
        queue.enqueue(12);
        queue.enqueue(41);
        queue.enqueue(29);
        System.out.println("Initial queue => " + stringifyQueue(queue));
        System.out.println();
        
        // Enqueue operation
        queue.enqueue(7);
        System.out.println("Enqueue 7 => " + stringifyQueue(queue));
        System.out.println("Size after inserting 7 => " + queue.size());
        System.out.println();
        
        // Dequeue operation
        System.out.println("Element at front => " + queue.peek());
        System.out.println("Dequeue => " + queue.dequeue());
        System.out.println("Queue after dequeue operation => " + stringifyQueue(queue));
        System.out.println();

        queue.enqueue(38);
        System.out.println("Enqueue 38 => " + stringifyQueue(queue));
        System.out.println();

        // Queue full exception
        System.out.println("Trying to enqueue 12 again in an already full queue; should throw an Exception");
        queue.enqueue(12);
    }

    private static <T> String stringifyQueue(Queue<T> queue) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (T element : queue) {
            stringJoiner.add(element.toString());
        }

        return stringJoiner.toString();
    }
}
public class PriorityQueueTester {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        System.out.println("Initial Queue => " + priorityQueue);
        System.out.println();

        // Add operation
        System.out.println("Add => 18, 5, 24");
        priorityQueue.add(18);
        priorityQueue.add(5);
        priorityQueue.add(24);
        System.out.println("Queue => " + priorityQueue);
        System.out.println();

        // Poll operation
        System.out.println("Poll the element with highest priority => " + priorityQueue.poll());
        System.out.println("Queue after polling => " + priorityQueue);
        System.out.println();

        System.out.println("Add some more elements => -12, 35");
        priorityQueue.add(-12);
        priorityQueue.add(35);
        System.out.println("Queue => " + priorityQueue);
        System.out.println();

        // Remove operation
        System.out.println("Remove 18 => " + priorityQueue.remove(18));
        System.out.println("Queue after removing 18 => " + priorityQueue);
        System.out.println();

        System.out.println("Poll next element with highest priority => " + priorityQueue.poll());
    }
}
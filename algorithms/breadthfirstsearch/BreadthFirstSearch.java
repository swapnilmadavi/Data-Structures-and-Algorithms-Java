import java.util.*;

public class BreadthFirstSearch {

    public static <T> Node<T> search(Node<T> start, T data) {
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visitedNodes = new HashSet<>();
        Node<T> currentNode;

        queue.add(start);

        while(!queue.isEmpty()) {
            currentNode = queue.remove();

            if (!visitedNodes.contains(currentNode)) { // Check only unvisited nodes
                if (currentNode.getData().equals(data)) { // Found node with given data
                    return currentNode;
                } else {
                    queue.addAll(currentNode.getNeighbors());
                    visitedNodes.add(currentNode);
                }
            }
        }

        return null;
    }   
}
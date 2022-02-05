import java.util.*;

/* Note: This class could be made more robust by overriding 
equals method to avoid logical duplicates in BFS queue*/
public class Node<T> {
    private T data;
    private Set<Node<T>> neighbors;

    public Node(T data) {
        this.data = data;
        this.neighbors = new HashSet<>();
    }

    public T getData() {
        return data;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void connect(Node<T> neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
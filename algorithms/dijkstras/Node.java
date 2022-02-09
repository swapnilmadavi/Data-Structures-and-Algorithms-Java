import java.util.*;

public class Node {
    private String name;
    private Map<Node, Integer> neighbors = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbor(Node neighborNode, int distance) {
        neighbors.put(neighborNode, distance);
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return name;
    }
}
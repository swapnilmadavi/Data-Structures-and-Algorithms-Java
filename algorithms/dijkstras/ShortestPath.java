import java.util.LinkedList;

public class ShortestPath {
    private Node source, destination;
    private int distance;
    private LinkedList<Node> path;

    public ShortestPath(Node source, Node destination, int distance, LinkedList<Node> path) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.path = path;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public LinkedList<Node> getPath() {
        return path;
    }
}
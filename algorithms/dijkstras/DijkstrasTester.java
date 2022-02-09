import java.util.*;

public class DijkstrasTester {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D"); 
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.addNeighbor(nodeB, 2);
        nodeA.addNeighbor(nodeC, 6);

        nodeB.addNeighbor(nodeD, 5);

        nodeC.addNeighbor(nodeD, 8);

        nodeD.addNeighbor(nodeE, 10);
        nodeD.addNeighbor(nodeF, 15);

        nodeE.addNeighbor(nodeF, 6);
        nodeE.addNeighbor(nodeG, 2);

        nodeF.addNeighbor(nodeG, 6);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);

        ShortestPath shortestPath = DijkstrasAlgorithm.findShortestPath(graph, nodeA, nodeG);

        System.out.println("Shortest path from Node A to Node G is:");
        System.out.println(stringifyPath(shortestPath.getPath()));
        System.out.println("Distance = " + shortestPath.getDistance());
    }

    private static String stringifyPath(LinkedList<Node> path) {
        StringJoiner stringJoiner = new StringJoiner(" -> ");

        for (Node node : path) {
            stringJoiner.add(node.toString());
        }

        return stringJoiner.toString();
    }


}
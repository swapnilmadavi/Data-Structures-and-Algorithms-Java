import java.util.*;

public class DijkstrasAlgorithm {
    public static int POSITIVE_INFINITY = Integer.MAX_VALUE;

    public static ShortestPath findShortestPath(Graph graph, Node source, Node destination) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> parents = new HashMap<>();
        Set<Node> processedNodes = new HashSet<>();

        initialiseDistancesAndParents(graph, distances, parents);

        distances.put(source, 0);
        Node currentNode = source;

        while (currentNode != null) {
            if (currentNode == destination) {
                return constructShortestPath(source, destination, distances.get(destination), parents);
            }

            for (Map.Entry<Node, Integer> neighborEntry : currentNode.getNeighbors().entrySet()) {
                Node neighborNode = neighborEntry.getKey();
                int newDistance = distances.get(currentNode) + neighborEntry.getValue();
                if (newDistance < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDistance);
                    parents.put(neighborNode, currentNode);
                }
            }

            processedNodes.add(currentNode);
            currentNode = findLowestDistanceNode(distances, processedNodes);
        }
        
        return null;
    }

    private static void initialiseDistancesAndParents(Graph graph, Map<Node, Integer> distances, Map<Node, Node> parents) {
        for (Node node : graph.getNodes()) {
            distances.put(node, POSITIVE_INFINITY);
            parents.put(node, null);
        }
    }

    private static Node findLowestDistanceNode(Map<Node, Integer> distances, Set<Node> processedNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        
        for (Map.Entry<Node, Integer> nodeEntry : distances.entrySet()) {
            Node node = nodeEntry.getKey();
            if (!processedNodes.contains(node)) {
                int nodeDistance = nodeEntry.getValue();
                if (nodeDistance < lowestDistance) {
                    lowestDistanceNode = node;
                    lowestDistance = nodeDistance;
                }
            }  
        }
        
        return lowestDistanceNode;
    }

    private static ShortestPath constructShortestPath(Node source, Node destination, int distance, Map<Node, Node> parents) {
        Node currentNode = destination;
        LinkedList<Node> path = new LinkedList<>();
        
        while (currentNode != null) {
            path.addFirst(currentNode);
            currentNode = parents.get(currentNode);
        }
        
        if (path.isEmpty() || path.getFirst() != source) {
            return null;
        }

        return new ShortestPath(source, destination, distance, path); 
    }
}
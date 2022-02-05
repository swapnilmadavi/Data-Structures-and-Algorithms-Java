import java.util.*;

public class BreadthFirstSearchTester {
    
    public static void main(String[] args) {
        Node<String> swapnil = new Node<>("Swapnil");
        Node<String> alice = new Node<>("Alice");
        Node<String> bob = new Node<>("Bob");
        Node<String> claire = new Node<>("Claire");
        Node<String> anuj = new Node<>("Anuj");
        Node<String> peggy = new Node<>("Peggy");
        Node<String> thom = new Node<>("Thom");
        Node<String> johnny = new Node<>("Johnny");

        swapnil.connect(alice);
        swapnil.connect(bob);
        swapnil.connect(claire);

        bob.connect(anuj);
        bob.connect(peggy);

        alice.connect(peggy);

        claire.connect(thom);
        claire.connect(johnny);

        executeBFS(swapnil, "Johnny");
        executeBFS(claire, "Bob");
    }

    private static void executeBFS(Node<String> startNode, String data) {
        System.out.println("Search " + data + " in " + startNode + "\'s network..");
        Node<String> bfsResult = BreadthFirstSearch.search(startNode, data);

        if (bfsResult != null) {
            System.out.println("Found => " + bfsResult);
        } else {
            System.out.println("Not found!");
        }
        System.out.println();
    }
}
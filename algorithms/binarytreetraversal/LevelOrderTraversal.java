import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {

    public static void traverse(BinaryTree binaryTree) {
        if (binaryTree.root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node node;

        queue.add(binaryTree.root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.leftChild != null) queue.add(node.leftChild);
            if (node.rightChild != null) queue.add(node.rightChild);
            System.out.print(node.data + " ");
        }
    }
}
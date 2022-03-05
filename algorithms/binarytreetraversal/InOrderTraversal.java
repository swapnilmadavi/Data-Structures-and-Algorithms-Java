import java.util.Stack;

public class InOrderTraversal {

    public static void traverse(BinaryTree binaryTree) {
        inOrderTraversal(binaryTree.root);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightChild);
    }

    public static void traverseIterative(BinaryTree binaryTree) {
        Stack<Node> stack = new Stack<>();
        Node root = binaryTree.root;

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.leftChild;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                // We have reached the left-most node, pop and print it
                root = stack.pop();
                System.out.print(root.data + " ");

                // Now process the right child node to follow the In-order Root-Right
                root = root.rightChild;
            }
        }
    }
}
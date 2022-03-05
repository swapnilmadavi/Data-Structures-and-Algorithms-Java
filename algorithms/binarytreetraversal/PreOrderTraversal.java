import java.util.Stack;

public class PreOrderTraversal {
    
    public static void traverse(BinaryTree binaryTree) {
        preOrderTraversal(binaryTree.root);
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public static void traverseIterative(BinaryTree binaryTree) {
        Stack<Node> stack = new Stack<>();
        Node root;
        
        if (binaryTree.root != null) {
            stack.push(binaryTree.root);
        }

        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.data + " ");

            if (root.rightChild != null) {
                stack.push(root.rightChild);
            }

            if (root.leftChild != null) {
                stack.push(root.leftChild);
            }
        }
    }
}
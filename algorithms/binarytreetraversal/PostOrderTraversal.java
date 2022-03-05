import java.util.Stack;

public class PostOrderTraversal {
    
    public static void traverse(BinaryTree binaryTree) {
        postOrderTraversal(binaryTree.root);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + " ");
    }

    public static void traverseIterative(BinaryTree binaryTree) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = binaryTree.root;
        Node tempNode;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                tempNode = stack.peek().rightChild;
                if (tempNode == null) {
                    tempNode = stack.pop();
                    System.out.print(tempNode.data + " ");

                    while (!stack.isEmpty() && tempNode == stack.peek().rightChild) {
                        tempNode = stack.pop();
                        System.out.print(tempNode.data + " ");
                    }
                } else {
                    currentNode = tempNode;
                }
            }
        }
    }

    public static void traverseIterative2Stack(BinaryTree binaryTree) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        Node node;

        if (binaryTree.root != null) {
            stack1.push(binaryTree.root);
        }

        while (!stack1.isEmpty()) {
            node = stack1.pop();

            if (node.leftChild != null) {
                stack1.push(node.leftChild);
            }

            if (node.rightChild != null) {
                stack1.push(node.rightChild);
            }

            stack2.push(node);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }
}
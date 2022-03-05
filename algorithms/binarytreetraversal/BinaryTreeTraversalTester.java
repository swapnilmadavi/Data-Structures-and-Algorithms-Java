// Todo: Print the binary tree in 2D before printing Traversals
public class BinaryTreeTraversalTester {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node<Integer>(1);
        binaryTree.root.leftChild = new Node<Integer>(2);
        binaryTree.root.rightChild = new Node<Integer>(3);
        binaryTree.root.leftChild.leftChild = new Node<Integer>(4);
        binaryTree.root.leftChild.rightChild = new Node<Integer>(5);

        /** Pre-order Traversal **/
        System.out.println("Pre-order Traversal:");
        
        // Pre-order Recursive
        System.out.print("Recursive => ");
        PreOrderTraversal.traverse(binaryTree);
        System.out.println();
        
        // Pre-order Iterative
        System.out.print("Iterative => ");
        PreOrderTraversal.traverseIterative(binaryTree);
        System.out.println("\n");

        /** In-order Traversal **/
        System.out.println("In-order Traversal:");
        
        // In-order Recursive
        System.out.print("Recursive => ");
        InOrderTraversal.traverse(binaryTree);
        System.out.println();
        
        // In-order Iterative
        System.out.print("Iterative => ");
        InOrderTraversal.traverseIterative(binaryTree);
        System.out.println("\n");


        /** Post-order Traversal **/
        System.out.println("Post-order Traversal:");
        
        // Post-order Recursive
        System.out.print("Recursive => ");
        PostOrderTraversal.traverse(binaryTree);
        System.out.println();
        
        // Post-order Iterative
        System.out.print("Iterative => ");
        PostOrderTraversal.traverseIterative(binaryTree);
        System.out.println();

        // Post-order Iterative using 2 Stacks
        System.out.print("Iterative using 2 Stacks => ");
        PostOrderTraversal.traverseIterative2Stack(binaryTree);
        System.out.println("\n");

        /** Level-order Traversal **/
        System.out.print("Level-order Traversal => ");
        LevelOrderTraversal.traverse(binaryTree);
        System.out.println();
    }
}
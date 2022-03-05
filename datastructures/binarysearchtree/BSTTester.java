public class BSTTester {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        System.out.println("Add 8\n");
        bst.add(8);

        System.out.println("Add 4\n");
        bst.add(4);

        System.out.println("Add 10\n");
        bst.add(10);

        System.out.println("Add 6\n");
        bst.add(6);

        System.out.println("Add 2\n");
        bst.add(2);

        System.out.println("Add 20\n");
        bst.add(20);

        System.out.println("Current height of the tree: " + bst.height());
        System.out.println();

        System.out.println("BST contains 10? => " + bst.contains(10));
        System.out.println();

        System.out.println("Remove 10\n");
        bst.remove(10);

        System.out.println("BST contains 10? => " + bst.contains(10));
        System.out.println();
    }
}
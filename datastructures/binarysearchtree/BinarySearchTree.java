// Todo: Add a print method which prints the BST in 2D.
public class BinarySearchTree<T extends Comparable<T>> {
    /*Static nested class as we don't require access to the
    Outer class's non-public fields and methods.*/
    private static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> root;
    private int nodeCount;

    public boolean add(T data) {
        if (contains(data)) {
            return false;
        }

        root = addRecusive(root, data);
        nodeCount++;
        return true;
    }

    private Node<T> addRecusive(Node<T> node, T data) {
        // If we found a blank spot after going past a leaf node, return a new Node to attach
        if (node == null) {
            return new Node<>(data);
        }

        // If the data is smaller than the current node's data, insert it into the left subtree
        if (data.compareTo(node.data) < 0) {
            node.leftChild = addRecusive(node.leftChild, data);
        } else { // If the data is greater than the current node's data, insert it into the right subtree
            node.rightChild = addRecusive(node.rightChild, data);
        }

        return node;
    }

    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int comparison = data.compareTo(node.data);

        if (comparison < 0) { // If the data is smaller than the current node's data, then search in the left subtree
            return containsRecursive(node.leftChild, data);
        } else if (comparison > 0) { // If the data is greater than the current node's data, then search in the right subtree
            return containsRecursive(node.rightChild, data);
        } else { // If the data matches the current node's data, return true.
            return true;
        }
    }

    public boolean remove(T data) {
        if (!contains(data)) {
            return false;
        }

        root = removeRecursive(root, data);
        nodeCount--;
        return true;
    }

    private Node<T> removeRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        int comparison = data.compareTo(node.data);

        if (comparison < 0) { // If the data is smaller than current node's data, find and remove in the left subtree.
            node.leftChild = removeRecursive(node.leftChild, data);
        } else if (comparison > 0) {
            node.rightChild = removeRecursive(node.leftChild, data);
        } else {  // If we found the data, remove it.
            // If there is no left subtree, simply return the right subtree for swapping. In case of no children, null will be returned.
            if (node.leftChild == null) {
                Node<T> rightChild = node.rightChild;
                node.data = null;
                node = null;
                return rightChild;
            } else if (node.rightChild == null) { // If there is no right subtree, simply return the left subtree for swapping.
                Node<T> leftChild = node.leftChild;
                node.data = null;
                node = null;
                return leftChild;
            } else {
                // If the node has both the children, swap the node's data with
                // 1. either the largest node in the left subtree
                // 2. or the smallest node in the right subtree
                // in-order to maintain the BST invariant and then remove the chosen largest or smallest node.
                // We have chosen the 2nd way.

                Node<T> smallestNode = findSmallestNode(node.rightChild);
                node.data = smallestNode.data;
                node.rightChild = removeRecursive(node.rightChild, smallestNode.data);
            }
        }

        return node;
    }

    private Node<T> findSmallestNode(Node<T> root) {
        Node<T> smallestNode = root;
        while (smallestNode.leftChild != null) {
            smallestNode = smallestNode.leftChild;
        }
        return smallestNode;
    }

    public int height() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node<T> node) {
        if (node == null) { // We are returning 0 as height of an empty tree.
            return 0;
        } else if (node.leftChild == null && node.rightChild == null) { // If both left & right subtrees are null, we found a tree/sub-tree with a single node whose height is taken as 0.
            return 0;
        } else if (node.leftChild == null) { // If left subtree is null, add the height of right subtree
            return calculateHeight(node.rightChild) + 1;
        } else if (node.rightChild == null) { // If right subtree is null, add the height of left subtree
            return calculateHeight(node.leftChild) + 1;
        } else {
            // If both subtrees are present, then add the longer subtree's height
            return Math.max(calculateHeight(node.leftChild), calculateHeight(node.rightChild)) + 1;
        }
    }
}
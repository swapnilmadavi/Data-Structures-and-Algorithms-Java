import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Priority Queue using Binary Heap.
 * Elements with higher priority are placed at top levels.
 * Time complexity:
 * Add - O(log(n))
 * Remove - O(log(n))
 */
public class PriorityQueue<T extends Comparable<T>> {
    private final List<T> heapList = new ArrayList<T>();

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null");
        heapList.add(element);
        int indexOfLastElement = size() - 1;
        bubbleUp(indexOfLastElement);
    }

    private void bubbleUp(int index) {
        int indexOfElement = index;
        int indexOfParent = getIndexOfParent(indexOfElement);
        while (indexOfElement > 0 && hasMorePriority(indexOfElement, indexOfParent)) {
            swap(indexOfElement, indexOfParent);
            indexOfElement = indexOfParent;
            indexOfParent = getIndexOfParent(indexOfElement);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = heapList.get(indexOne);
        heapList.set(indexOne, heapList.get(indexTwo));
        heapList.set(indexTwo, temp);
    }

    private int getIndexOfParent(int indexOfElement) {
        return (indexOfElement - 1) / 2;
    }

    private boolean hasMorePriority(int indexOfElement, int indexOfParent) {
        T elementAtChildIndex = heapList.get(indexOfElement);
        T elementAtParentIndex = heapList.get(indexOfParent);
        return elementAtChildIndex.compareTo(elementAtParentIndex) > 0;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heapList.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean remove(T element) {
        if (element == null) return false;
        int indexOfElement = indexOf(element);
        if (indexOfElement == -1) return false;
        removeAt(indexOfElement);
        return true;
    }

    private T removeAt(int index) {
        int heapSize = size();
        if (heapSize == 0) return null;
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index must be within the list; found " + index);
        if (heapSize == 1 && index == 0) return heapList.remove(0);

        int indexOfLastElement = heapSize - 1;
        swap(index, indexOfLastElement);
        T element = heapList.remove(indexOfLastElement);
        bubbleDown(index);
        return element;
    }

    private void bubbleDown(int index) {
        int indexOfElement = index;
        int heapSize = size();
        int indexOfChildWithGreaterPriority = 0;
        while (true) {
            int indexOfLeftChild = getIndexOfLeftChild(indexOfElement);
            int indexOfRightChild = getIndexOfRightChild(indexOfElement);

            // Stop if there are no children.
            // Since heap is a complete binary tree, having no left child implies there is no right child as well.
            if (indexOfLeftChild >= heapSize) break;

            // By default, left child is considered first for comparison
            indexOfChildWithGreaterPriority = indexOfLeftChild;

            // Check if there is a right child and if it has greater priority among both the children.
            // Select the child having greater priority for comparison with parent
            if (indexOfRightChild < heapSize && hasMorePriority(indexOfRightChild, indexOfLeftChild)) {
                indexOfChildWithGreaterPriority = indexOfRightChild;
            }

            // Stop if the element being bubbled down has reached its place.
            if (!hasMorePriority(indexOfChildWithGreaterPriority, indexOfElement)) break;

            // Else swap the element with the child having more priority.
            swap(indexOfElement, indexOfChildWithGreaterPriority);
            indexOfElement = indexOfChildWithGreaterPriority;
        }
    }

    private int getIndexOfLeftChild(int indexOfElement) {
        return (2 * indexOfElement) + 1;
    }

    private int getIndexOfRightChild(int indexOfElement) {
        return (2 * indexOfElement) + 2;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int size() {
        return heapList.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size(); i++) {
            if (heapList.get(i).equals(element)) return i;
        }
        return -1;
    }

     @Override
    public String toString() {
        return heapList.toString();
    }
}
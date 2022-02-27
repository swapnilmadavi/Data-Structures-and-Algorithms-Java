import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {
    /*Static nested class as we don't require access to the
    Outer class's non-public fields and methods.*/
    private static class Node<T> {
        private T data;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> head;
    private int length = 0;

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
        } else if (length == 1) {
            head.next = newNode;
        } else {
            Node<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        length++;
    }

    public void addAt(int index, T data) {
        if (index < 0) throw new IllegalArgumentException("Index must be positive");
        if (index >= size())
            throw new IllegalArgumentException("Index must be less the size of the list");

        Node<T> newNode = new Node<T>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> previousIndexNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousIndexNode = previousIndexNode.next;
            }
            newNode.next = previousIndexNode.next;
            previousIndexNode.next = newNode;
        }

        length++;
    }

    public void addFirst(T data) {
        addAt(0, data);
    }

    public T removeAt(int index) {
        if (index < 0) throw new IllegalArgumentException("Index must be positive");
        if (index >= size())
            throw new IllegalArgumentException("Index must be less the size of the list");

        T data;
        
        if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            Node<T> previousIndexNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousIndexNode = previousIndexNode.next;
            }
            data = previousIndexNode.next.data;
            previousIndexNode.next = previousIndexNode.next.next;
        }

        length--;
        return data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("List already empty");
        return removeAt(0);
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("List already empty");
        return removeAt(length - 1);
    }

    public boolean remove(T data) {
        if (isEmpty()) return false;

        if (head.data.equals(data)) {
            removeAt(0);
            return true;
        }

        Node<T> currentNode = head.next;
        Node<T> previousNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                previousNode.next = currentNode.next;
                currentNode = null;
                length--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean contains(T data) {
        if (isEmpty()) return false;

        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        if (!isEmpty()) {
            head = null;
            length = 0;
        }
    }

    public void clearWithoutGC() {
        if (head != null) {
            Node<T> currentNode = head;
            Node<T> nextNode = null;
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode = null;
                currentNode = nextNode;
            }
            head = null;
            length = 0;
        }
    }

    public int indexOf(T data) {
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
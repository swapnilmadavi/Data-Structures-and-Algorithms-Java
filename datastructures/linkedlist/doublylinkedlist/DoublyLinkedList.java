import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next = null;
        private Node<T> previous = null;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index must be within the list; found " + index);

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            if (isEmpty()) {
                tail = newNode;
            }
            newNode.next = head;
            head = newNode;
        } else if (index == (length - 1)) {
            newNode.previous = tail.previous;
            newNode.next = tail;
            tail.previous.next = newNode;
            tail.previous = newNode;
        } else {
            int middleIndex = length / 2;
            if (index <= middleIndex) {
                Node<T> previousIndexNode = head;
                for (int i = 0; i < index - 1; i++) {
                    previousIndexNode = previousIndexNode.next;
                }
                newNode.previous = previousIndexNode;
                newNode.next = previousIndexNode.next;
                previousIndexNode.next.previous = newNode;
                previousIndexNode.next = newNode;
            } else {
                Node<T> currentNodeAtGivenIndex = tail.previous;
                for (int i = length - 2; i > index; i--) {
                    currentNodeAtGivenIndex = currentNodeAtGivenIndex.previous;
                }
                newNode.previous = currentNodeAtGivenIndex.previous;
                newNode.next = currentNodeAtGivenIndex;
                currentNodeAtGivenIndex.previous.next = newNode;
                currentNodeAtGivenIndex.previous = newNode;
            }
        }

        length++;
    }

    public void addFirst(T data) {
        addAt(0, data);
    }

    public T removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("List already empty");
        
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index must be within the list; found " + index);

        T data;

        if (index == 0) {
            data = head.data;
            head = head.next;
            if (length == 1) {
                tail = null;
            } else if (length == 2) {
                tail.previous = null;
            }
        } else if (index == (length - 1)) {
            data = tail.data;
            tail = tail.previous;
            if (length == 1) {
                head = null;
            } else if (length == 2) {
                head.next = null;
            }
        } else {
            Node<T> nodeAtGivenIndex;
            int middleIndex = length / 2;
            if (index < middleIndex) {
                nodeAtGivenIndex = head.next;
                for (int i = 1; i < index; i++) {
                    nodeAtGivenIndex = nodeAtGivenIndex.next;
                }
            } else {
                nodeAtGivenIndex = tail.previous;
                for (int i = length - 2; i > index; i--) {
                    nodeAtGivenIndex = nodeAtGivenIndex.previous;
                }
            }
            data = nodeAtGivenIndex.data;
            nodeAtGivenIndex.previous.next = nodeAtGivenIndex.next;
            nodeAtGivenIndex.next.previous = nodeAtGivenIndex.previous;
            nodeAtGivenIndex = null;
        }

        length--;
        return data;
    }


    public T removeFirst() {
        return removeAt(0);
    }

    public T removeLast() {
        return removeAt(size() - 1);
    }

    public boolean remove(T data) {
        if (isEmpty()) throw new RuntimeException("List already empty");
        
        if (head.data.equals(data)) {
            removeFirst();
            return true;
        }

        if (tail.data.equals(data)) {
            removeLast();
            return true;
        }

        Node<T> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                currentNode = null;
                length--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index must be within the list; found " + index);

        if (index == 0) {
            head.data = data;
        } else if (index == length - 1) {
            tail.data = data;
        } else {
            Node<T> nodeAtGivenIndex;
            int middleIndex = length / 2;
            if (index < middleIndex) {
                nodeAtGivenIndex = head.next;
                for (int i = 1; i < index; i++) {
                    nodeAtGivenIndex = nodeAtGivenIndex.next;
                }
            } else {
                nodeAtGivenIndex = tail.previous;
                for (int i = length - 2; i > index; i--) {
                    nodeAtGivenIndex = nodeAtGivenIndex.previous;
                }
            }
            nodeAtGivenIndex.data = data;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index must be within the list; found " + index);

        if (index == 0) {
            return head.data;
        } else if (index == length - 1) {
            return tail.data;
        } else {
            Node<T> nodeAtGivenIndex;
            int middleIndex = length / 2;
            if (index < middleIndex) {
                nodeAtGivenIndex = head.next;
                for (int i = 1; i < index; i++) {
                    nodeAtGivenIndex = nodeAtGivenIndex.next;
                }
            } else {
                nodeAtGivenIndex = tail.previous;
                for (int i = length - 2; i > index; i--) {
                    nodeAtGivenIndex = nodeAtGivenIndex.previous;
                }
            }
            return nodeAtGivenIndex.data;
        }
    }


    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
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

    public void clear() {
        if (!isEmpty()) {
            head = tail = null;
            length = 0;
        }
    }

    public void clearWithoutGC() {
        if (!isEmpty()) {
            Node<T> currentNode = head;
            Node<T> nextNode = null;
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.data = null;
                currentNode.previous = currentNode.next = null;
                currentNode = nextNode;
            }
            head = tail = null;
            length = 0;
        }
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
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
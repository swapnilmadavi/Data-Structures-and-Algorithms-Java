import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private int capacity, size;
    private int stackTop = -1;
    private T[] array;

    public Stack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("must be greater than 0");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public Stack() {
        this(10);
    }

    public void push(T element) {
        if (isFull()) throw new StackOverflowError();
        array[++stackTop] = element;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T poppedElement = array[stackTop];
        stackTop--;
        size--;
        return poppedElement;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return array[stackTop];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[--i];
            }
        };
    }
}
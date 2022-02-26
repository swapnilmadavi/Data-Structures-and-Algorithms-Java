import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {
    private int capacity;
    private int length;
    private T[] array;

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("must be greater than or equal to 0");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public DynamicArray() {
        this(10);
    }

    public void add(T element) {
        if (length == capacity) {
            grow();
        }
        array[length] = element;
        length++;
    }

    public T remove() {
        if (isEmpty()) throw new RuntimeException("Array already empty");
        return removeAt(length - 1);
    }

    public T removeAt(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Index: " + index);
        
        // Remove element at given index
        T removedElement = array[index];
        // Shift elements to left by one position to fill the gap
        int i = index;
        while (i < length - 1) {
            array[i] = array[i + 1];
            i++;
        }
        array[i] = null;
        // Update length
        length--;
        return removedElement;
    }

    public T get(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Index: " + index);
        return array[index];
    }

    public T set(int index, T element) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException("Index: " + index);
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void shrinkToSize() {
        if (length < capacity) {
            T[] newArray = (T[]) new Object[length];
            for (int i = 0; i < length; i++) {
                newArray[i] = array[i];
            }
            capacity = length;
            array = newArray;
        }
    }

    public void clear() {
        for (int i = 0; i < length; i++) array[i] = null;
        length = 0;
    }

    private void grow() {
        // Increase capacity
        if (capacity == 0) {
            capacity = 1;
        } else {
            capacity = capacity * 2;
        }
        // Copy elements from old array
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < length;
            }

            @Override
            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = array[i];
                i++;
                return element;
            }
        };
    }
}
package structure;

// 动态数组
public class DynamicArray<E> {

    private E[] data;

    private int size;

    private static final int INIT_CAP = 1;

    public DynamicArray() {
        this(INIT_CAP);
    }

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E element) {

    }

    public void remove(int index) {

    }

    public void set(int index, E elemet) {

    }

    public E get(int index) {
        return null;
    }

}
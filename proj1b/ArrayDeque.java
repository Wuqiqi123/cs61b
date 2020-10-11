import java.util.BitSet;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INIT_CAPACITY = 8;
    private static final int RFACTOR = 2;
    private static final double MIN_USAGE_RATIO = 0.25;

    public ArrayDeque(){
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = INIT_CAPACITY / 2;
        nextLast = nextFirst + 1;
    }

    public ArrayDeque(ArrayDeque<T> other){
        int newlength = other.size() * 2;
        items = (T[]) new Object[newlength];
        size = other.size();
        for (int i=0; i<other.size(); i++){
            items[i] = other.get(i);
        }
        nextFirst = newlength - 1;
        nextLast = size;
    }

    private int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index){
        return (index + 1) % items.length;
    }

    private void resize(int cap) {
        T[] newArray = (T []) new Object[cap];
        nextFirst = plusOne(nextFirst);
        for (int i =0; i< size(); i++){
            newArray[i] = items[nextFirst];
            nextFirst = plusOne(nextFirst);
        }
        items = newArray;
        // the nextFirst's next is the first one, and index =0 is the is the first one,
        // and nextFirst is the last one of whole cap.
        nextFirst = cap - 1;
        nextLast = size;
    }

    /** Adds an item of type T to the front of the deque.*/
    @Override
    public void addFirst(T item) {
        if (size == items.length){
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    /* Adds an item of type T to the back of the deque*/
    @Override
    public void addLast(T item) {
        if (size == items.length){
            resize(size * RFACTOR);
        }
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (items.length >= 16 && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    @Override
    public T removeLast() {
        if (size == 0){
            return null;
        }
        nextLast = minusOne(nextLast);
        T removedItem = items[nextLast];
        items[nextLast] = null;
        size--;
        if (items.length >= 16 && size < items.length * MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    @Override
    public T get(int index){
        if (index >= size){
            return null;
        }
        int realIndex = (nextFirst + 1 + index) % items.length;
        return items[realIndex];
    }

    @Override
    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i=0; i<size; i++) {
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
        System.out.println();
    }
}

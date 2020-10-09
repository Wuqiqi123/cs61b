/** This interface defines a method for determining equality of characters. */
public interface Deque<T> {
    /** Returns true if characters are equal by the rules of the implementing class. */
    default boolean isEmpty(char x, char y) {
        return size() == 0;
    }
    public void addLast(T item);
    public void addFirst(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}

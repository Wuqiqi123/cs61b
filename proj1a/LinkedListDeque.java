public class LinkedListDeque<T> {

    private class Node {
        private final T item;
        private Node next;
        private Node prev;
        public Node(Node p, T a, Node n) {
            prev = p;
            item = a;
            next = n;
        }
    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i=0; i<other.size(); i++){
            addLast(other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    /* Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        Node newNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if(size == 0){
            return null;
        }
        Node removedNode = sentinel.next;
        sentinel.next = removedNode.next;
        removedNode.next.prev = sentinel;
        size--;
        return removedNode.item;
    }

    public T removeLast() {
        if(size == 0){
            return null;
        }
        Node removedNode = sentinel.prev;
        sentinel.prev = removedNode.prev;
        removedNode.prev.next = sentinel;
        size--;
        return removedNode.item;
    }

    public T get(int index){
        if (index >= size) {
            return null;
        }
        Node temp = sentinel.next;
        for(int i =0; i< index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public void printDeque() {
        Node temp  = sentinel.next;
        for(int i =0; i< size; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T getRecursive(int index){
        if (index >= size){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node start){
        if (index == 0){
            return start.item;
        }
        return getRecursiveHelper(index-1, start.next);
    }
}

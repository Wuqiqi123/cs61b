



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

    private final Node sentinelFront;
    private final Node sentinelBack;
    private int size;

    public LinkedListDeque(){
        sentinelFront = new Node(null, null, null);
        sentinelBack = new Node(null, null, null);
        sentinelFront.next = sentinelBack;
        sentinelBack.prev = sentinelFront;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        Node node = new Node(sentinelFront, item,  sentinelFront.next);
        sentinelFront.next.prev = node;
        sentinelFront.next = node;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        Node node = new Node(sentinelBack.prev, item,  sentinelBack);
        sentinelBack.prev.next = node;
        sentinelBack.prev = node;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if(sentinelFront.next == sentinelBack) {
           return null;
        }
        Node removedNode = sentinelFront.next;
        sentinelFront.next = removedNode.next;
        removedNode.next.prev = sentinelFront;
        size--;
        return removedNode.item;
    }

    public T removeLast() {
        if(sentinelBack.prev == sentinelFront) {
            return null;
        }
        Node removedNode = sentinelBack.prev;
        sentinelBack.prev = removedNode.prev;
        removedNode.prev.next = sentinelBack;
        size--;
        return removedNode.item;

    }

    public T get(int index){
        int i= 0;
        Node temp = sentinelFront.next;
        while(i<index){
            if (temp == sentinelBack){
                break;
            }
            temp = temp.next;
            i++;
        }
        return (temp == sentinelBack) ? null : temp.item;
    }

    public void printDeque() {
        for(int i=0;i<size; i++) {
            if (i == size - 1){
                System.out.println(get(i));
            }
            else {
                System.out.print(get(i) + " ");
            }

        }
    }
}
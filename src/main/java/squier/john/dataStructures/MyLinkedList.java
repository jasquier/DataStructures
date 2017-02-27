package squier.john.dataStructures;

/**
 * @author John A. Squier
 */
public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T value) {
        Node<T> next = new Node<>(value);
        next.setNext(null);

        // this is the very first node added
        if ( head == null ) {
            head = next;
            tail = head;
        } // there are already nodes in the list
        else {
            tail.setNext(next);
            tail = next;
        }
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Node current = head;
        int indexAt = 0;

        if ( current == null ) {
            throw new ListHasNoElementsException("The list has no elements in it.");
        }

        while ( current != null ) {
            if ( indexAt == index ) {
                return (T)current.getValue();
            }
            current = current.getNext();
            indexAt++;
        }
        throw new IndexOutOfBoundsException("index " + index + " not found.");
    }

    private class Node<T> {

        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

package squier.john.dataStructures;

/**
 * @author John A. Squier
 */
public class MyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        size = 0;
        head = tail = null;
    }

    public boolean add(T value) {
        Node<T> next = new Node<>(value);
        next.setNext(null);

        if ( head == null ) {
            head = next;
            tail = head;
        }
        else {
            tail.setNext(next);
            tail = next;
        }
        size++;
        return true;
    }

    public T remove(int index) {
        Node<T> current = head, previous = null;
        int indexAt = 0;

        while ( current != null ) {
            if ( indexAt == index ) {
                if ( current == head ) {
                    head = current.getNext();
                }
                else if ( current == tail ) {
                    previous.setNext(null);
                }
                else {
                    previous.setNext(current.getNext());
                }
                size--;
                return current.getValue();
            }
            previous = current;
            current = current.getNext();
            indexAt++;
        }
        throw new IndexOutOfBoundsException("index " + index + " not found.");
    }

    // TODO combine some of get()'s logic with contains()
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Node<T> current = head;
        int indexAt = 0;

        while ( current != null ) {
            if ( indexAt == index ) {
                return (T)current.getValue();
            }
            current = current.getNext();
            indexAt++;
        }
        throw new IndexOutOfBoundsException("index " + index + " not found.");
    }

    // TODO contains repeat code with get, combine somehow
    public boolean contains(T value) {
        Node<T> current = head;
        boolean result = false;

        while ( current != null ) {
            if ( current.getValue().equals(value) ) {
                result = true;
            }
            current = current.getNext();
        }
        return result;
    }

    public int size() {
        return size;
    }

    public int find(T value) {
        Node<T> current = head;
        int index = 0;

        if ( contains(value) ) {
            while ( current != null ) {
                if ( current.getValue().equals(value) ) {
                    return index;
                }
                current = current.getNext();
                index++;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        String result = "";

        if ( current == null ) {
            result = "no elements in the list";
        }
        else {
            while ( current != null ) {
                result += "value: " + current.getValue() + "\n";
                current = current.getNext();
            }
        }
        return result;
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
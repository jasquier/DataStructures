package squier.john.dataStructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author John A. Squier
 */
public class MyLinkedList<E> implements List<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;
    private Node<E> current;

    public MyLinkedList() {
        size = 0;
        head = tail = null;
    }

    public boolean add(E e) {
        Node<E> next = new Node<>(e);
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

    @SuppressWarnings("unchecked")
    public void add(int index, E element) {
        Node<E> toAdd = new Node<>(element);
        current = getNodeAt(index-1);

        if ( index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds");
        }
        else if ( head == null ) { // add to an empty list
            add(element);
        }
        else if ( index == 0 ) { // add to the beginning of a non empty list
            toAdd.setNext(head);
            head = toAdd;
            size++;
        }
        else if ( current == null ) { // add to the end of the list
            tail.setNext(toAdd);
            toAdd.setNext(null);
            tail = toAdd;
            size++;
        }
        else {                      // add to the middle of the list
            toAdd.setNext(current.getNext());
            current.setNext(toAdd);
            size++;
        }
        return;
    }

    public boolean addAll(Collection<? extends E> c) {
        for ( E e : c ) {
            add(e);
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        for ( E e : c ) {
            add(i, e);
            i++;
        }
        return true;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(Object o) {
        current = head;
        boolean result = false;

        while ( current != null ) {
            if ( current.getValue().equals(o) ) {
                result = true;
            }
            current = current.getNext();
        }
        return result;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            boolean result = contains(o);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public MyLinkedList<E> copy() {
        MyLinkedList<E> copiedList = new MyLinkedList<>();

        for ( int i = 0; i < this.size(); i++ ) {
            copiedList.add(this.get(i));
        }
        return copiedList;
    }


    public boolean equals(Object o) {
        return false;
    }

    public int find(E value) {
        current = head;
        int index = 0;

        while ( current != null ) {
            if ( current.getValue().equals(value) ) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        current = head;
        int indexAt = 0;

        while ( current != null ) {
            if ( indexAt == index ) {
                return current.getValue();
            }
            current = current.getNext();
            indexAt++;
        }
        throw new IndexOutOfBoundsException("index " + index + " not found.");
    }

    public int hashCode() {
        return -1;
    }

    public int indexOf(Object o) {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public int lastIndexOf(Object o) {
        return -1;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public E remove(int index) {
        Node<E> previous = null;
        current = head;
        int indexAt = 0;

        while ( current != null ) {
            if ( indexAt == index ) {
                return deleteNode(current, previous);
            }
            previous = current;
            current = current.getNext();
            indexAt++;
        }
        throw new IndexOutOfBoundsException("index " + index + " not found.");
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean reverse() {
        return false;
    }

    public E set(int index, E element) {
        return null;
    }

    public int size() {
        return size;
    }

    public List<E> subList(int formIndex, int toIndex) {
        return null;
    }

    public Object[] toArray() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public String toString() {
        current = head;
        String result = "";

        if ( current == null ) {
            result = "no elements in the list";
        }
        else {
            while ( current != null ) {
                if ( current == head ) {
                    result += "head--->";
                }
                if ( current == tail ) {
                    result += "tail--->";
                }
                result += "value: " + current.getValue() + "\n";
                current = current.getNext();
            }
        }
        return result;
    }

    private E deleteNode(Node<E> current, Node<E> previous) {
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

    private Node getNodeAt(int index) {
        current = head;
        int indexAt = 0;

        while ( current != null ) {
            if ( indexAt == index ) {
                return current;
            }
            indexAt++;
            current = current.getNext();
        }
        return current;
    }

    private class Node<T> {

        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
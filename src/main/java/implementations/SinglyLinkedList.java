package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        E removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    @Override
    public E removeLast() {
        if (head == null) {
            throw new IllegalStateException("Empty");
        }

        E removedData;
        if (head.next == null) {
            // Only one element in the list
            removedData = head.data;
            head = null;
        } else {
            Node<E> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = null;
        }
        size--;
        return removedData;
    }

    @Override
    public E getFirst() {
        if (head == null) {
            throw new IllegalStateException("Empty");
        }
        return head.data;
    }

    @Override
    public E getLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // You can implement an iterator here if needed
        return null;
    }
}

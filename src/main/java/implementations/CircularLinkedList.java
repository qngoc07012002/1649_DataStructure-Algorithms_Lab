package implementations;

public class CircularLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private Node<E> current;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void insertAfter(int index, E data) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Cannot insert element.");
            return;
        }

        Node<E> newNode = new Node<>(data);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }

        size++;
    }

    public void insertLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = head;
        }
        size--;
    }

    public void removeAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Cannot remove element.");
            return;
        }
        if (index == 0) {
            head = head.next;
            tail.next = head;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (index == size - 1) {
                tail = current;
            }
        }
        size--;
    }

    public E getNext() {
        if (isEmpty()){
            return null;
        } else
        if (current == null || current.next == null) {
            current = head;
            return current.data;
        } else {
            current = current.next;
            return current.data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node<E> current = head;
        if (head != null) {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }
}
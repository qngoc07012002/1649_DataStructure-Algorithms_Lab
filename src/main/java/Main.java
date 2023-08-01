import implementations.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        methodA();
    }

    public static void methodA() {
        System.out.println("MeThod A");
        methodB();
    }

    public static void methodB() {
        System.out.println("Method B");
    }


    //testStack();
    // testQueue();
    //  testDLL();
    public static void testStack(){
        Stack<Integer> stackTest = new Stack<Integer>();
        stackTest.push(1);
        stackTest.push(3);
        stackTest.push(5);
        stackTest.push(7);

        // Pop 2 elements
        System.out.println("Pop 2 Elements: ");
        System.out.println(stackTest.pop());
        System.out.println(stackTest.pop());
        System.out.println();

        // Peek element
        System.out.println("Peek Element: ");
        System.out.println(stackTest.peek());
        System.out.println();

        // Check size
        System.out.println("Check Size: ");
        System.out.println(stackTest.size());
        System.out.println();

        // Check Empty
        System.out.println("Check Empty: ");
        System.out.println(stackTest.isEmpty());
        System.out.println();

         // Display
        System.out.println("Display Stack: ");
        System.out.println(stackTest);
    }

    public static void testQueue(){
        Queue2<Integer> queueTest = new Queue2<Integer>();
        queueTest.offer(1);
        queueTest.offer(3);
        queueTest.offer(5);
        queueTest.offer(7);
        System.out.println(queueTest);

        // Pop 2 element
        System.out.println(queueTest.poll());
        System.out.println(queueTest.poll());
        System.out.println();

        // Peek element
        System.out.println(queueTest.peek());
        System.out.println();

        // Check Empty
        System.out.println(queueTest.isEmpty());
        System.out.println();

        // Iterator
        Iterator<Integer> queueIterator = queueTest.iterator();
        while (queueIterator.hasNext()){
            System.out.println(queueIterator.next());
        }
    }

    public static void testDLL(){
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.insertLast(10);
        dll.insertLast(20);
        dll.insertFirst(5);
        dll.insertAfter(dll.getNode(1), 15);

        System.out.println("Display Forward:");
        dll.displayForward();

        System.out.println("Display Backward:");
        dll.displayBackward();

        dll.removeFirst();
        dll.removeAtIndex(1);

        System.out.println("After removing first and second elements:");
        dll.displayForward();
        dll.displayBackward();

        dll.insertFirst(5);
        dll.insertLast(25);

        System.out.println("After inserting 5 at the front and 25 at the back:");
        dll.displayForward();
        dll.displayBackward();

        System.out.println("List size: " + dll.getSize()); // Output: List size: 4
    }

}

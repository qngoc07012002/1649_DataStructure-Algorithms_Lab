import implementations.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
      //  testStack();
        testQueue();
    }

    public static void testStack(){
        Stack2<Integer> stackTest = new Stack2<Integer>();
        stackTest.push(1);
        stackTest.push(3);
        stackTest.push(5);
        stackTest.push(7);
        System.out.println(stackTest);

        // Pop 2 element
        System.out.println(stackTest.pop());
        System.out.println(stackTest.pop());
        System.out.println();

        // Peek element
        System.out.println(stackTest.peek());
        System.out.println();

        // Check size
        System.out.println(stackTest.size());
        System.out.println();

        // Check Empty
        System.out.println(stackTest.isEmpty());
        System.out.println();

         // Iterator
        Iterator<Integer> stackIterator = stackTest.iterator();
        while (stackIterator.hasNext()){
            System.out.println(stackIterator.next());
        }
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
}

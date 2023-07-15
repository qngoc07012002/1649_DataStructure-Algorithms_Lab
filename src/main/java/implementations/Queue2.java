package implementations;
import interfaces.AbstractQueue;

import java.util.Iterator;
public class Queue2<E> implements AbstractQueue<E> {
    private int size;
    private ArrayList<E> arrayList = new ArrayList<E>();

    @Override
    public void offer(E element) {
        arrayList.add(element);
        this.size++;
    }

    private void ensureNonEmpty(){
        if (arrayList.isEmpty()){
            throw new IllegalStateException("Queue Null");
        }
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        this.size--;
        return arrayList.remove(0);
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return arrayList.get(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (arrayList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return (index < size);
            }

            @Override
            public E next() {
                index++;
                return arrayList.get(index-1);
            }
        };
    }
}

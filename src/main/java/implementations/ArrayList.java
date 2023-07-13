package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private  int size;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length){
            this.elements = grow();
        }
        this.elements[this.size++] = element;
        return true;
    }

    private  Object[] grow(){
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        insert(index, element);
        return true;
    }

    private void insert(int index, E element){
        if (this.size == this.elements.length){
            this.elements = grow();
        }
        E lastElement = this.getElement(this.size-1);
        for (int i = this.size - 1; i > index; i--){
            this.elements[i] = this.elements[i-1];
        }
        this.elements[this.size] = lastElement;
        this.elements[index] = element;
        this.size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return this.getElement(index);

    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = this.getElement(index);
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        this.checkIndex(index);
        E element = this.getElement(index);
        this.elements[index] = null;
        this.size--;
        shift(index);
        ensureCapacity();
        return element;
    }

    private void ensureCapacity(){
        if (this.size < this.elements.length / 3){
            this.elements = shrink();
        }
    }

    private E getElement(int index) {
        checkIndex(index);
        return (E) this.elements[index];
    }

    private void shift(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size] = null;
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    private void checkIndex(int index){
        if (index < 0 || index >= this.size){
            throw   new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d",index,this.size));
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i=0; i<this.size; i++){
            if (element.equals(this.elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private  int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size();
            }
            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}

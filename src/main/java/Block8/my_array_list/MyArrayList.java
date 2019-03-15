package Block8.my_array_list;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] values;
    private int count;

    public MyArrayList() {
        this.values = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {

        try {
            E[] temp = values;
            increaseSize();
            System.arraycopy(temp, 0, values, 0, count);
            values[count] = e;
            count++;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    @Override
    public void delete(int index) {

        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int countAfterDeleteNumber = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, countAfterDeleteNumber);
            count--;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(values, count);
    }

    private void increaseSize() {
        int arraySize = values.length;
        if (count >= arraySize) {
            int newSize = arraySize * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }
}

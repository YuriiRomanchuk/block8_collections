package Block8.my_array_list;


import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] values;
    private int count;

    public MyIterator(E[] values, int count) {
        this.values = values;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return index < count;
    }

    @Override
    public E next() {
        return values[index++];
    }
}

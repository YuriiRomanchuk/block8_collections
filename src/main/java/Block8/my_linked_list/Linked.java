package Block8.my_linked_list;

import java.util.Iterator;

public interface Linked<E> extends DescendingIterator<E>, Iterable<E>{

    void addLast(E e);

    void addFirst(E e);

    int size();

    void remove(E e);

    void remove(int index);

    E getElementsByIndex(int index);

    @Override
    Iterator<E> descendingIterator();

    @Override
    Iterator<E> iterator();
}

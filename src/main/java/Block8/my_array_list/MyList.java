package Block8.my_array_list;

public interface MyList<E> extends Iterable<E> {

    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

}

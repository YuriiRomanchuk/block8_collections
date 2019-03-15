package Block8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class ArrayListWithOutRemove<E> extends ArrayList<E> {

    public ArrayListWithOutRemove(int i) {
        super(i);
    }

    public ArrayListWithOutRemove(Collection<? extends E> collection) {
        super(collection);
    }

    public ArrayListWithOutRemove() {
        super();
    }


    @Override
    @Deprecated
    public E remove(int i) {
        removeMessage();
        return null;
    }

    @Override
    @Deprecated
    public boolean remove(Object o) {
        removeMessage();
        return false;
    }


    @Override
    @Deprecated
    protected void removeRange(int i, int i1) {
        removeMessage();
    }

    @Override
    @Deprecated
    public boolean removeAll(Collection<?> collection) {
        removeMessage();
        return false;
    }

    @Override
    @Deprecated
    public boolean removeIf(Predicate<? super E> predicate) {
        removeMessage();
        return false;
    }

    private void removeMessage() {
        System.out.println("The remove operation is disabled.");
    }
}

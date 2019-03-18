package Block8.my_hash_map;

import java.util.Iterator;

public interface MyMap<K, V> extends Iterable<V> {

    boolean insert(K key, V value);
    boolean delete(K key);
    V get(K key);
    int size();

    @Override
    public Iterator<V> iterator();
}

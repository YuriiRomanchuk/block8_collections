package Block8.my_hash_map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private Node<K, V>[] hashTable;
    private int size;
    private float threshold;


    public MyHashMap() {
        this.hashTable = new Node[DEFAULT_INITIAL_CAPACITY];
        this.threshold = hashTable.length * DEFAULT_LOAD_FACTOR;
    }

    @Override
    public boolean insert(K key, V value) {

        if (size + 1 > threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);

        if (hashTable[index] == null) {
            return addValue(index, newNode);
        }

        List<Node<K, V>> nodes = hashTable[index].getNodes();

        for (Node<K, V> node : nodes) {

            if (keyExistButNewValue(node, newNode, value) ||
                    collisionProcessing(node, newNode, nodes)) {
                return true;
            }

        }

        return false;
    }

    private boolean collisionProcessing(final Node<K, V> node, final Node<K, V> newNode, final List<Node<K, V>> nodes) {

        if (newNode.hashCode() == node.hashCode() &&
                !newNode.getKey().equals(node.getKey()) &&
                !newNode.getValue().equals(node.getValue())) {

            nodes.add(newNode);
            size++;
            return true;

        }

        return false;
    }

    private boolean keyExistButNewValue(final Node<K, V> node, final Node<K, V> newNode, final V currentValue) {

        if (newNode.getKey().equals(node.getKey()) &&
                !newNode.getValue().equals(node.getValue())) {

            node.setValue(newNode.getValue());
            return true;
        }

        return false;
    }

    private boolean addValue(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private void arrayDoubling() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;

        for (Node<K, V> node : oldHashTable) {
            if (node == null) {
                for (Node<K, V> nodeNode : node.getNodes()) {
                    insert(nodeNode.getKey(), nodeNode.getValue());
                }
            }
        }

    }

    @Override
    public boolean delete(final K key) {

        int index = hash(key);

        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null;
            return true;
        }

        List<Node<K, V>> nodes = hashTable[index].getNodes();

        for (Node<K, V> node : nodes) {
            if (node.getKey().equals(key)) {
                nodes.remove(node);
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(K key) {

        int index = hash(key);

        if (index < hashTable.length &&
                hashTable[index] != null) {

            List<Node<K, V>> nodes = hashTable[index].getNodes();

            if (nodes.size() == 1) {
                return nodes.get(0).getValue();
            }

            for (Node<K, V> node : nodes) {
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }


    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int counterArray;
            int valuesCounter;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {

                if (valuesCounter == size) {
                    return false;
                }

                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveNextCell()) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                        counterArray++;
                    } else {
                        return false;
                    }

                }

                return subIterator.hasNext();
            }

            private boolean moveNextCell() {

                while (counterArray < hashTable.length && hashTable[counterArray] == null) {
                    counterArray++;
                }

                return counterArray < hashTable.length && hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }


    private class Node<K, V> {

        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.nodes = new LinkedList<Node<K, V>>();
            this.key = key;
            this.value = value;
        }

        private int receiveHash() {
            return hashCode() % hashTable.length;
        }


        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setNodes(List<Node<K, V>> nodes) {
            this.nodes = nodes;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }


        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.getHash()));
            }

            return false;


        }
    }

}

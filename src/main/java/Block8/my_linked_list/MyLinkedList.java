package Block8.my_linked_list;

import java.util.Iterator;

public class MyLinkedList<E> implements Linked<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        this.firstNode = new Node<>(null, null, lastNode);
        this.lastNode = new Node<>(null, firstNode, null);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<E>(null, prev, null);
        prev.setNextElement(lastNode);
        prev.getPrevElement().setNextElement(prev);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> first = firstNode;
        first.setCurrentElement(e);
        firstNode = new Node<>(null, null, first);
        first.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(E e) {
    }

    @Override
    public void remove(int index) {
        Node<E> currentNode = receiveNodeByIndex(index);
        Node<E> prev = currentNode.getPrevElement();
        Node<E> next = currentNode.getNextElement();
        prev.setNextElement(next);
        currentNode.setNextElement(null);
        next.setPrevElement(prev);
        currentNode.setPrevElement(null);
        size--;
    }

    private Node<E> receiveNodeByIndex(int index) {
        Node<E> currentNode = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextElement();
        }

        return currentNode;
    }

    @Override
    public E getElementsByIndex(int index) {

        Node<E> currentNode = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextElement();
        }
        return currentNode.getCurrentElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementsByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {

            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementsByIndex(counter--);
            }
        };
    }

    private static class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }
    }


}

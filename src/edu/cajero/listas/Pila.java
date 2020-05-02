package edu.cajero.listas;

import java.util.NoSuchElementException;

public class Pila<T> implements PilaInt<T> {

    private class Node<T>
    {
        private T data;
        private Node<T> next;

        public Node()
        {
            data = null;
            next = null;
            size = 0;
        }
        public Node (T newData, Node<T> linkValue)
        {
            data = newData;
            next = linkValue;
            size++;
        }
    }

    private Node<T> topOfStackRef = null;
    private int size;

    @Override
    public T push(T obj) {
        topOfStackRef = new Node<>(obj, topOfStackRef);
        return obj;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return topOfStackRef.data;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            T result = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            size--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return topOfStackRef == null;
    }

    @Override
    public int size() {
        return size;
    }
}

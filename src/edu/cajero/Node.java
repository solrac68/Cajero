package edu.cajero;

public class Node<E> {
    private E data;
    private int count;
    public Node<E> next;
    public Node(E dataItem) {
        data = dataItem;
        next = null;
    }
    public Node(E dataItem, Node<E> nodeRef) {
        data = dataItem;
        next = nodeRef;
    }
    public E getData(){
        return data;
    }
}

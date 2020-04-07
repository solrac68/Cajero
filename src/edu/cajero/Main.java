package edu.cajero;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Java.");

        Node<String> mao = new Node<String>("Magnolia");
        Node<String> carlos = new Node<>("Carlos");
        Node<String> santiago = new Node<>("Santiago");
        Node<String> andres = new Node<>("Andres");
        mao.next = carlos;
        carlos.next = santiago;
        santiago.next = andres;

        System.out.println("El hijo de mao es: " + mao.next.getData());
        System.out.println("El hijo de carlos es: " + mao.next.next.getData());
        System.out.println("El hijo de santiago es: " + mao.next.next.next.getData());
        System.out.println("El hijo de santiago es: " + mao.next.next.next.next.getData());


    }
}

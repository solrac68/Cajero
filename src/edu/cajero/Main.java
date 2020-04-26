package edu.cajero;

import java.util.Date;
import java.util.Scanner;

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
        andres.next = mao;

        System.out.println("El hijo de mao es: " + mao.next.getData());
        System.out.println("El hijo de carlos es: " + mao.next.next.getData());
        System.out.println("El hijo de santiago es: " + mao.next.next.next.getData());
        System.out.println("La hija de andres es: " + andres.next.getData());

        Node<Integer> uno = new Node<Integer>(1);
        Node<Integer> dos = new Node<Integer>(2);
        Node<Integer> tres = new Node<Integer>(3);

        uno.next = dos;
        dos.next = tres;
        tres.next = uno;

        System.out.println("El hijo de 1: " + uno.next.getData());
        System.out.println("El hijo de 2: " + dos.next.getData());
        System.out.println("El hijo de 3: " + tres.next.getData());

        Cliente cliente1 = new Cliente();
        cliente1.setIdentificacion("101213712683");
        cliente1.setGenero("M");
        cliente1.setNombre("Santiago Augusto");
        cliente1.setFechaNacimiento(new Date());

        Cliente cliente2 = new Cliente();
        cliente2.setIdentificacion("938792445");
        cliente2.setGenero("M");
        cliente2.setNombre("Carlos Andres");
        cliente2.setFechaNacimiento(new Date());

        Cliente cliente3 = new Cliente();
        cliente3.setIdentificacion("197128738");
        cliente3.setGenero("F");
        cliente3.setNombre("Magnolia del Carmen");
        cliente3.setFechaNacimiento(new Date());

        Node<Cliente> node1 = new Node<Cliente>(cliente1);
        Node<Cliente> node2 = new Node<Cliente>(cliente2);
        Node<Cliente> node3 = new Node<Cliente>(cliente3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println("El hijo de node1: " + node1.getData().getNombre());
        System.out.println("El hijo de node2: " + node2.getData().getNombre());
        System.out.println("El hijo de node3: " + node3.getData().getNombre());


        Scanner lector = new Scanner(System.in);
        String nombre,identificacion,genero,fecha;
        int dato;
        float saldoInicial;
        boolean respuesta=false;

        while (!respuesta)
        {
            System.out.println("");
            System.out.println("---MENU---");
            System.out.println("1.Usuario");
            System.out.println("2.Registrate");
            System.out.println("3.Salir");

            System.out.println("Digite una de las opciones:");
            dato=lector.nextInt();
            //clear();
            switch (dato)
            {
                case 1:


                    break;
                case 2:
                    identificacion=lector.nextLine();
                    System.out.print("Digite su identificación: ");
                    identificacion=lector.nextLine();
                    System.out.println("Digite su nombre: ");
                    nombre=lector.nextLine();
                    System.out.println("digite su genero hombre(h),mujer(m),otros(o):");
                    genero=lector.nextLine();
                    System.out.println("Digite su fecha de nacimiento: ");
                    fecha=lector.nextLine();
                    System.out.println("Saldo inicial:");
                    saldoInicial=lector.nextFloat();
                    //clear();
                    break;
                case 3:
                    System.out.println("Ejecucion finalizada");
                    respuesta=true;
                    break;
                default:
                    System.out.println("El numero ingresado no esta entre las opciones...");

            }
        }







    }
}

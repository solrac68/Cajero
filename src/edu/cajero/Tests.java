package edu.cajero;

import edu.cajero.dtos.Cliente;
import edu.cajero.dtos.Entry;
import edu.cajero.listas.ListaDobleCircular;
import edu.cajero.listas.ListaDobleEnlazada;
import edu.cajero.listas.ListaEnlazada;

import java.time.LocalDate;

public class Tests {
    public static void testLinkedListDouble(){
        ListaDobleEnlazada<Cliente> list = new ListaDobleEnlazada<>();

        Cliente cliente1 =
                new Cliente("71701882","Carlos Augusto Hincapie", Cliente.Genero.Male, LocalDate.of(1968, 7,15));
        Cliente cliente2 =
                new Cliente("10921301","Carlos Andres Hincapie", Cliente.Genero.Male,LocalDate.of(2005, 8,20));
        Cliente cliente3 =
                new Cliente("826183","Santiago Augusto Hincapie", Cliente.Genero.Male,LocalDate.of(1999, 5,20));
        Cliente cliente4 =
                new Cliente("21777231","Magnolia OLiveros Aguirre", Cliente.Genero.Female,LocalDate.of(1965, 6,15));

        Cliente cliente5 =
                new Cliente("22345987999","Rafael Orlando OLi", Cliente.Genero.Male,LocalDate.of(1964, 3,10));


        list.add(cliente1);
        list.add(cliente2);
        list.add(cliente3);
        list.add(cliente4);
        list.add(0,cliente5);

        System.out.printf("\nList has %d nodos \n\n",list.size());
        list.outputList();
        //System.out.printf("\nPosicion 1: %s\n", list.get(1).toString());

        Cliente clienteN =
                new Cliente("21987234","Alicia Romero García", Cliente.Genero.Female,LocalDate.of(1927, 3,10));



        list.set(0,clienteN);

        System.out.printf("\n\n***Actualizado el cliente %s \n\n\n",clienteN.toString());

        list.outputList();


        if (list.remove(cliente4) == true)
            System.out.printf("\n\n--Eliminado cliente4---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();


        if (list.remove(clienteN) == true)
            System.out.printf("\n\n--Eliminado clienteN---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();

        if (list.remove(cliente2) == true)
            System.out.printf("\n\n--Eliminado cliente2---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();

        if(list.add(cliente5) == true)
            System.out.printf("\n\n--AGREGADO cliente5---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO SE AGREGO INFORMACIÓN");

        list.outputList();

    }

    public static void testLinkedList(){
        ListaEnlazada<Entry> list = new ListaEnlazada<Entry>();

        Entry entry1 = new Entry("Apples", 1);
        list.add(0,entry1);
        Entry entry2 = new Entry("Bananas", 2);
        list.add(0,entry2);
        Entry entry3 = new Entry("Cantaloupe", 3);
        list.add(0,entry3);
        Entry entry4 = new Entry("Toronja", 100);
        list.add(entry4);
        System.out.printf("\nList has %d nodos \n\n",list.size());
        list.outputList();

        Entry entry = new Entry("Orange", 5);

        list.set(1,entry);

        System.out.printf("\nActualiza entry has %d nodos \n\n",list.size());
        list.outputList();

        int posi = list.indexOf(entry3);
        System.out.printf("Posicion de %s es %d \n",entry3.toString(),posi);
        Entry entrada = list.remove(posi);
        System.out.printf("La entrada entry3 fue eliminada es %s \n\nTamaño: %d\n\n",entry.toString(),list.size());
        list.outputList();

        Entry apples = new Entry("Apples", 3);

        if (list.remove(apples) == true) {
            System.out.printf("\n\n Eliminado Apples\n\nTamaño: %d",list.size());
            list.outputList();
        }
        else
            System.out.printf("NO EXISTE ELEMENTO");

        //entry4

        if (list.remove(entry4) == true) {
            System.out.printf("\n\nEliminado entry4\n\nTamaño: %d\n\n",list.size());
            list.outputList();
        }
        else
            System.out.printf("NO EXISTE ELEMENTO");

        Entry mango = new Entry("Mango", 5);

        if(list.add(mango)==true){
            System.out.printf("\n\nAgregada mango\n\nTamaño: %d\n\n",list.size());
            list.outputList();
        }
    }

    public static void testCircularList(){
        ListaDobleCircular<Cliente> list = new ListaDobleCircular<>();

        Cliente cliente1 =
                new Cliente("71701882","Carlos Augusto Hincapie", Cliente.Genero.Male, LocalDate.of(1968, 7,15));
        Cliente cliente2 =
                new Cliente("10921301","Carlos Andres Hincapie", Cliente.Genero.Male,LocalDate.of(2005, 8,20));
        Cliente cliente3 =
                new Cliente("826183","Santiago Augusto Hincapie", Cliente.Genero.Male,LocalDate.of(1999, 5,20));
        Cliente cliente4 =
                new Cliente("21777231","Magnolia OLiveros Aguirre", Cliente.Genero.Female,LocalDate.of(1965, 6,15));

        Cliente cliente0 =
                new Cliente("22345987999","Rafael Orlando OLi", Cliente.Genero.Male,LocalDate.of(1964, 3,10));


        list.add(cliente1);
        list.add(cliente2);
        list.add(cliente3);
        list.add(cliente4);
        list.add(0,cliente0);

        System.out.printf("\nLa lista tiene %d nodos \n",list.size());
        System.out.printf("\nImprimiendo de la cabeza hacia adelante\n");
        list.outputList();

        System.out.printf("\nImprimiendo de la cola hacia atras\n");
        list.outputListReverse();

        if (list.remove(cliente0) == true)
            System.out.printf("\n\n--Eliminado cliente0---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();


        if (list.remove(cliente4) == true)
            System.out.printf("\n\n--Eliminado cliente4---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();

        if (list.remove(cliente2) == true)
            System.out.printf("\n\n--Eliminado cliente2---\nTamaño:%d\n",list.size());
        else
            System.out.printf("NO EXISTE ELEMENTO");

        list.outputList();

        if (list.remove(cliente2) == true)
            System.out.printf("\n\n--Intentando eliminar cliente2---\nTamaño:%d\n",list.size());
        else
            System.out.printf("\nNO EXISTE ELEMENTO\n");

        list.outputList();



    }
}

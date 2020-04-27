package edu.cajero;

import java.util.Date;
import java.util.Scanner;

public class Main {

    static LinkedListDouble<Cliente> listaClientes = new LinkedListDouble<>();
    public static void main(String[] args) {
        //testLinkedList();
        //testLinkedListDouble();

        int respuesta;
        while ((respuesta = menuMain()) != 4){
            System.out.printf("Respuesta es: %d",respuesta);
            switch (respuesta) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuCuentas();
                    break;
                case 3:
                    menuOperaciones();
                    break;
            }
        }
        System.out.printf("\n\nSALIENDO DE LA APLICACIÓN");

    }

    public static void testLinkedListDouble(){
        LinkedListDouble<Cliente> list = new LinkedListDouble<>();

        Cliente cliente1 =
                new Cliente("71701882","Carlos Augusto Hincapie", Cliente.Genero.Male,new Date(1968, 7,15));
        Cliente cliente2 =
                new Cliente("10921301","Carlos Andres Hincapie", Cliente.Genero.Male,new Date(2005, 8,20));
        Cliente cliente3 =
                new Cliente("82618381","Santiago Augusto Hincapie", Cliente.Genero.Male,new Date(1999, 5,20));
        Cliente cliente4 =
                new Cliente("21777231","Magnolia OLiveros Aguirre", Cliente.Genero.Female,new Date(1965, 6,15));

        Cliente cliente5 =
                new Cliente("22345987","Rafael Orlando OLi", Cliente.Genero.Male,new Date(1964, 3,10));


        list.add(cliente1);
        list.add(cliente2);
        list.add(cliente3);
        list.add(cliente4);
        list.add(0,cliente5);

        System.out.printf("\nList has %d nodos \n\n",list.size());
        list.outputList();
        //System.out.printf("\nPosicion 1: %s\n", list.get(1).toString());

        Cliente clienteN =
                new Cliente("21987234","Alicia Romero García", Cliente.Genero.Female,new Date(1927, 3,10));



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
        LinkedList<Entry> list = new LinkedList<Entry>();

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

    public static int menu(){
        Scanner lector = new Scanner(System.in);
        String nombre,identificacion,genero,fecha;
        int dato;
        float saldoInicial;
        boolean respuesta=false;

        while (!respuesta)
        {
            System.out.println("");
            System.out.println("---MENU---");
            System.out.println("1.Clientes");
            System.out.println("2.Cuentas");
            System.out.println("3.Operaciones");

            System.out.println("Digite una de las opciones (1/2/3):");
            dato=lector.nextInt();
            //clear();
            switch (dato)
            {
                case 1:
                    System.out.printf("Selecciono la opción: %d",dato);
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

        return 0;
    }

    public static int menuMain(){
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("---MENU PRINCIPAL---");
        System.out.println("1.Clientes");
        System.out.println("2.Cuentas");
        System.out.println("3.Operaciones");
        System.out.println("4.SALIR");

        System.out.println("Digite una de las opciones (1/2/3 o 4):");
        return lector.nextInt();
    }

    public static int menuCli(){
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("---MENU CLIENTES---");
        System.out.println("1.Ingresar");
        System.out.println("2.Consultar");
        System.out.println("3.Modificar");
        System.out.println("4.Eliminar");
        System.out.println("5.SALIR");

        System.out.println("Digite una de las opciones: ");
        return lector.nextInt();
    }
    public static void menuClientes(){
        int respuesta;

        while((respuesta = menuCli()) != 5){
            switch (respuesta) {
                case 1:
                    ingresarClientes();
                    break;
                case 2:
                    consultarClientes();
                    break;
                case 3:
                    modificarClientes();
                    break;
                case 4:
                    eliminarClientes();
                    break;
            }
        }
    }

    public static void ingresarClientes(){
        Scanner lector = new Scanner(System.in);
        Cliente cliente = getCliente();
        listaClientes.add(cliente);
        System.out.printf("\nCliente Ingresado, Digite cualquier tecla para continuar ");
        lector.nextLine();
    }

    public static Cliente getCliente(){
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nNombre del Cliente : ");
        String nombreCliente = lector.nextLine();

        System.out.printf("\nCedula del Cliente : ");
        String idCliente = lector.nextLine();

        System.out.printf("\nGenero (M/F) : ");
        String genero = lector.nextLine();

        System.out.printf("\nAño de nacimiento :");
        Integer ano = lector.nextInt();
        System.out.printf("\nMes de nacimiento (1-12) :");
        Integer mes = lector.nextInt();
        System.out.printf("\nDia de nacimiento (1-31) :");
        Integer dia = lector.nextInt();

        Date fechaNacimiento = new Date(ano,mes,dia);

        Cliente cliente = new Cliente(idCliente,
                nombreCliente,
                (genero.toLowerCase().equals("f")?Cliente.Genero.Female: Cliente.Genero.Male),
                fechaNacimiento);

        return cliente;

    }
    public static void consultarClientes(){
        Scanner lector = new Scanner(System.in);
        listaClientes.outputList();
        System.out.printf("\nClientes Consultados, Digite cualquier tecla para continuar ");
        lector.nextLine();
    }
    public static void modificarClientes(){
        listaClientes.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nDigite la identificacion del Cliente que se modificara: ");
        String idCliente = lector.nextLine();
        Cliente cliente = getCliente(idCliente);

    }

    public static Cliente getClienteAModificar(Cliente cliente){
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nNombre actual del Cliente: %s",cliente.getNombre());
        String nombreCliente = lector.nextLine();
        if (nombreCliente.trim().length() == 0)
            nombreCliente = cliente.getNombre();

        String idCliente = cliente.getIdCliente();

        System.out.printf("\nGenero actual del cliente: %s (M/F) : ",cliente.getGenero().toString());
        String genero = lector.nextLine();

       // if(genero.trim().length() == 0) genero = cliente.getGenero();

        System.out.printf("\nAño actual de nacimiento : %s",cliente.getFechaNacimiento().getYear());
        Integer ano = lector.nextInt();
        System.out.printf("\nMes de nacimiento (1-12) :");
        Integer mes = lector.nextInt();
        System.out.printf("\nDia de nacimiento (1-31) :");
        Integer dia = lector.nextInt();

        Date fechaNacimiento = new Date(ano,mes,dia);

        cliente = new Cliente(idCliente,
                nombreCliente,
                (genero.toLowerCase().equals("f")?Cliente.Genero.Female: Cliente.Genero.Male),
                fechaNacimiento);

        return cliente;

    }

    public static Cliente getCliente(String idCliente){
        return listaClientes.findData(new Cliente(idCliente,"",Cliente.Genero.Female, new Date() ));
    }


    public static void eliminarClientes(){

    }

    public static void menuCuentas(){
    }

    public static void menuOperaciones(){
    }


}

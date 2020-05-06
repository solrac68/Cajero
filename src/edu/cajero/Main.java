package edu.cajero;

import edu.cajero.dtos.Cliente;
import edu.cajero.dtos.Cuenta;
import edu.cajero.listas.ListaDobleEnlazada;
import edu.cajero.listas.ListaEnlazada;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static ListaDobleEnlazada<Cliente> listaClientes = new ListaDobleEnlazada<>();
    static ListaEnlazada<Cuenta> listaCuenta = new ListaEnlazada<>();

    public static void main(String[] args) {

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
        System.out.printf("\nSALIENDO DE LA APLICACIÓN");

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

    public static int menuCli(String titulo){
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println(titulo);
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

        while((respuesta = menuCli("---MENU CLIENTES---")) != 5){
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
        Cliente cliente = getClienteNuevo();
        listaClientes.add(cliente);
        System.out.printf("\nCliente Ingresado, Presione cualquier tecla para continuar ");
        lector.nextLine();
    }

    public static Cliente getClienteNuevo(){
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

        LocalDate fechaNacimiento = LocalDate.of(ano,mes,dia);

        Cliente cliente = new Cliente(idCliente,
                nombreCliente,
                (genero.toLowerCase().equals("f")?Cliente.Genero.Female: Cliente.Genero.Male),
                fechaNacimiento);

        return cliente;

    }

    public static void consultarClientes(){
        Scanner lector = new Scanner(System.in);
        listaClientes.outputList();
        System.out.printf("\nClientes Consultados, Presione cualquier tecla para continuar ");
        lector.nextLine();
    }

    public static void modificarClientes(){
        listaClientes.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nDigite la identificacion del Cliente que se modificara: ");
        String idCliente = lector.nextLine();
        Cliente cliente = listaClientes.findData(new Cliente(idCliente,"",Cliente.Genero.Female, LocalDate.now()));
        if (cliente != null) {
            Cliente clienteMod = getClienteModificar(cliente);
            Integer idClienteMod = listaClientes.indexOf(cliente);

            // Actualizando cliente
            Cliente cli = listaClientes.set(idClienteMod,clienteMod);
            if(cli != null){
                System.out.printf("\nEl cliente con identificación %s fue actualizado exitosamente, presione cualquier tecla para continuar", cli.getIdCliente());
                lector.nextLine();
            }
        }
        else {
            System.out.printf("\nLa identificación %s No existe en el sistema ", idCliente);
        }


    }

    public static Cliente getClienteModificar(Cliente cliente){
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nNombre actual: %s",cliente.getNombre());
        System.out.printf("\nEscriba el Nombre nuevo o Enter para No modificar: ");
        String nombreCliente = lector.nextLine();
        if (nombreCliente.trim().length() == 0)
            nombreCliente = cliente.getNombre();

        // La identificación no cambia
        String idCliente = cliente.getIdCliente();

        System.out.printf("\nGenero actual del cliente: %s (M/F) : ",cliente.getGenero().toString());
        System.out.printf("\nEscriba el nuevo genero (M/F) o Enter para No modificar: ");
        String genero = lector.nextLine();
       if(genero.trim().length() == 0)
           genero = cliente.getGenero() == Cliente.Genero.Male ? "m":"f";

        System.out.printf("\nAño actual de nacimiento : %d",cliente.getFechaNacimiento().getYear());
        System.out.printf("\nEscriba el nuevo año o Enter para No modificar: ");
        String ano_s = lector.nextLine();
        int ano;
        if(ano_s.trim().length() == 0)
            ano = cliente.getFechaNacimiento().getYear();
        else
            ano = Integer.parseInt(ano_s);


        System.out.printf("\nMes actual de nacimiento : %d",cliente.getFechaNacimiento().getMonthValue());
        System.out.printf("\nEscriba el nuevo mes (1-12) o Enter para No modificar: ");
        String mes_s = lector.nextLine();
        Integer mes;
        if(mes_s.trim().length() == 0)
            mes = cliente.getFechaNacimiento().getMonthValue();
        else
            mes = Integer.parseInt(mes_s);

        System.out.printf("\nDia actual de nacimiento : %d",cliente.getFechaNacimiento().getDayOfMonth());
        System.out.printf("\nEscriba el nuevo dia (1-31) o Enter para No modificar: ");
        String dia_s = lector.nextLine();
        Integer dia;
        if(dia_s.trim().length() == 0)
            dia = cliente.getFechaNacimiento().getDayOfMonth();
        else
            dia = Integer.parseInt(dia_s);


        LocalDate fechaNacimiento = LocalDate.of(ano,mes,dia);

        cliente = new Cliente(idCliente,
                nombreCliente,
                (genero.toLowerCase().equals("f")?Cliente.Genero.Female: Cliente.Genero.Male),
                fechaNacimiento);

        return cliente;

    }

    public static void eliminarClientes(){
        listaClientes.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nDigite la identificacion del Cliente que se eliminara: ");
        String idCliente = lector.nextLine();
        Cliente cliente = listaClientes.findData(new Cliente(idCliente,"",Cliente.Genero.Female, LocalDate.now()));
        if (cliente != null)
        {
            //Integer idClienteToDelete = listaClientes.indexOf(cliente);
            //Actualizando cliente
            boolean cliEstado = listaClientes.remove(cliente);
            if(cliEstado)
            {
                System.out.printf("\nEl cliente con identificación %s fue eliminado de la base de datos, presione cualquier tecla para continuar", cliente.getIdCliente());
                lector.nextLine();
            }
        }
        else
            {
            System.out.printf("\nLa identificación %s No existe en el sistema ", idCliente);
            }
    }

    public static void menuCuentas()
    {
        int respuesta;

        while((respuesta = menuCli("---MENU CUENTAS---")) != 5){
            switch (respuesta) {
                case 1:
                    ingresarCuentas();
                    break;
                case 2:
                    consultarCuentas();
                    break;
                case 3:
                    //modificarCuentas();
                    break;
                case 4:
                    eliminarCuentas();
                    break;
            }
        }
    }

    public  static  void eliminarCuentas()
    {
        listaCuenta.outputList();
        Scanner lector = new Scanner(System.in);
        System.out.printf("\nDigite el numero de cuenta que se eliminara: ");
        String NumCuenta = lector.nextLine();
        System.out.printf("\nDigite el saldo que se eliminara junto a la cuenta:");
        double Saldo=lector.nextDouble();
        Cuenta cuenta=listaCuenta.findData(new Cuenta(NumCuenta,"",Saldo));
        if(cuenta!=null)
        {
            boolean cueEstado=listaCuenta.remove(cuenta);

            if(cueEstado)
            {
                System.out.printf("\nLa cuenta de numeros %s fue eliminado de la base de datos, presione cualquier tecla para continuar", cuenta.getNumCuenta());
                lector.nextLine();
            }
        }
        else
            {
                System.out.printf("\nEl numero de cuenta %s No existe en el sistema ", NumCuenta);
            }
    }

   // public static void modificarCuentas()
    /*{
        listaCuenta.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.println("\nDigite el numero de cuenta que se desea modificar:");
        String numCuenta=lector.nextLine();
        System.out.printf("\nDigite la identificacion del Cliente que se modificara: ");
        String idCliente = lector.nextLine();
        System.out.println("\nDigite el saldo a modificar:");
        double saldo=lector.nextDouble();

        Cuenta cuenta=listaCuenta.findData(new Cuenta(numCuenta,"",saldo));
        if(cuenta!=null)
        {
            Cuenta cuentaMod=getCuentaModificar(cuenta);
            Integer IdcuentaMod=listaCuenta.indexOf(cuenta);
        }
        //Actualizando cuenta

        Cuenta cuen=listaCuenta.set(IdcuentaMod);

        if(cuen!=null)
        {
            System.out.println("La cuenta con numero %s fue actualizada exitosamente,presione cualquier tecla para continuar",cli.getIdcuenta());
        }

        else
            {
                System.out.println("La cuenta %s no ha sido registrada.",numCuenta);
            }
    }

    public static Cuenta getCuentaModificar(Cuenta cuenta)
    {
        Scanner lector = new Scanner(System.in);
        System.out.printf("\nNumero de cuenta actual: %s",cuenta.getNumCuenta());
        System.out.printf("\nEscriba el nuevo numero de cuenta o enter para no modificar:");
        String Numcuenta=lector.nextLine();

        if(Numcuenta.trim().length()==0)
            Numcuenta = cuenta.getNumCuenta();

        // El numero de cuenta no cambia
        String idCuenta = cuenta.getNumCuenta();






        return cuenta;
    }/*{
        listaCuenta.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.println("\nDigite el numero de cuenta que se desea modificar:");
        String numCuenta=lector.nextLine();
        System.out.printf("\nDigite la identificacion del Cliente que se modificara: ");
        String idCliente = lector.nextLine();
        System.out.println("\nDigite el saldo a modificar:");
        double saldo=lector.nextDouble();

        Cuenta cuenta=listaCuenta.findData(new Cuenta(numCuenta,"",saldo));
        if(cuenta!=null)
        {
            Cuenta cuentaMod=getCuentaModificar(cuenta);
            Integer IdcuentaMod=listaCuenta.indexOf(cuenta);
        }
        //Actualizando cuenta

        Cuenta cuen=listaCuenta.set(IdcuentaMod);

        if(cuen!=null)
        {
            System.out.println("La cuenta con numero %s fue actualizada exitosamente,presione cualquier tecla para continuar",cli.getIdcuenta());
        }

        else
            {
                System.out.println("La cuenta %s no ha sido registrada.",numCuenta);
            }
    }*/

    public static void consultarCuentas()
    {
        Scanner lector = new Scanner(System.in);
        listaCuenta.outputList();
        System.out.printf("\nCuentas Consultadas, Presione cualquier tecla para continuar ");
        lector.nextLine();
    }

public static void ingresarCuentas()
{

    Scanner lector = new Scanner(System.in);
    Cuenta cuenta = getCuentaNueva();
    listaCuenta.add(cuenta);
    System.out.printf("\nCuenta Ingresada, Presione cualquier tecla para continuar ");
    lector.nextLine();
}

public static Cuenta getCuentaNueva()
    {
        listaClientes.outputList();
        Scanner lector = new Scanner(System.in);

        System.out.printf("\nNumero de cuenta: ");
        String numCuenta = lector.nextLine();

        System.out.printf("\nDigite su identificacion : ");
        String idCliente = lector.nextLine();

        System.out.printf("\nDigite con cuanto desea registrar la cuenta: ");
        double saldo=lector.nextDouble();



        Cuenta cuenta = new Cuenta(numCuenta,idCliente,saldo);
                //(genero.toLowerCase().equals("f")?Cliente.Genero.Female: Cliente.Genero.Male),
                //fechaNacimiento);

        return cuenta;
    }

    public static void menuOperaciones()
    {
    }


}

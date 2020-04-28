package edu.cajero.dtos;

import java.time.LocalDate;

public class Cliente {
    public enum Genero {Male, Female};
    public Cliente(String idCliente, String nombre, Genero genero, LocalDate fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString()
    {
        return String.format("Id Cliente: %-15s\tNombre: %-30s\tGenero: %-5s\tNacimiento: %-20s",
                this.idCliente,this.nombre,this.genero.toString(),this.fechaNacimiento.toString());
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Cliente cliente = (Cliente)otherObject;
//            return this.nombre.equals(cliente.nombre)
//                    && this.fechaNacimiento.equals(cliente.fechaNacimiento)
//                    && this.genero.equals(cliente.genero)
//                    && this.idCliente.equals(cliente.idCliente);

            return this.idCliente.equals(cliente.idCliente);
        }
    }

    private String idCliente;
    private String nombre;
    private Genero genero;
    private LocalDate fechaNacimiento;
}

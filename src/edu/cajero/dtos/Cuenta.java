package edu.cajero.dtos;

public class Cuenta {

    public Cuenta(String numCuenta, String idCliente, Double saldo) {
        this.numCuenta = numCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public String toString()
    {
        return String.format("Numero de Cuenta: %-15s\tId Cliente: %-30s\tSaldo: %-6.2f",this.numCuenta,this.idCliente,this.saldo = saldo);
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Cuenta cuenta = (Cuenta)otherObject;
            return this.numCuenta.equals(cuenta.numCuenta) &&
                    this.idCliente.equals(cuenta.idCliente) &&
                    (this.saldo == cuenta.saldo);
        }
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private String numCuenta;
    private String idCliente;
    private Double saldo;
}

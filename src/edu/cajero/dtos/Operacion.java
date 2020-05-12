package edu.cajero.dtos;


import java.time.LocalDateTime;

public class Operacion {
    public Operacion(int consecutivo, String numCuenta, LocalDateTime fechaHoraOperacion, Double valor, TipoOperacion tipoOperacion) {
        this.consecutivo = consecutivo;
        this.numCuenta = numCuenta;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.valor = valor;
        this.tipoOperacion = tipoOperacion;
    }

    public String toString()
    {
        return String.format("Consecutivo: %-15d\tNum Cuenta: %-30s\tValor: %-6.2f\tTipo Operacion: %-30s\tFecha Operacion: %-30s",
                this.consecutivo,this.numCuenta,this.valor,this.tipoOperacion.toString(),this.fechaHoraOperacion.toString());
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public LocalDateTime getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(LocalDateTime fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public enum TipoOperacion {Consignacion, Retiro};

    private int consecutivo;
    private String numCuenta;
    private LocalDateTime fechaHoraOperacion;
    private Double valor;
    private TipoOperacion tipoOperacion;

}

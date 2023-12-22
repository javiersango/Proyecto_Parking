/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Javier
 */
public class Reserva {
      private int id;
    private int idVehiculo;
    private int numeroPlaza;
    private boolean reservada;
    private Date fechaReservada;
    private int horasReserva;
    private double precioPorMinuto;
    private double precioTotal;

    public Reserva(int id, int idVehiculo, int numeroPlaza, boolean reservada, Date fechaReservada, int horasReserva, double precioPorMinuto, double precioTotal) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.numeroPlaza = numeroPlaza;
        this.reservada = reservada;
        this.fechaReservada = fechaReservada;
        this.horasReserva = horasReserva;
        this.precioPorMinuto = precioPorMinuto;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    public Date getFechaReservada() {
        return fechaReservada;
    }

    public void setFechaReservada(Date fechaReservada) {
        this.fechaReservada = fechaReservada;
    }

    public int getHorasReserva() {
        return horasReserva;
    }

    public void setHorasReserva(int horasReserva) {
        this.horasReserva = horasReserva;
    }

    public double getPrecioPorMinuto() {
        return precioPorMinuto;
    }

    public void setPrecioPorMinuto(double precioPorMinuto) {
        this.precioPorMinuto = precioPorMinuto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", idVehiculo=" + idVehiculo + ", numeroPlaza=" + numeroPlaza + ", reservada=" + reservada + ", fechaReservada=" + fechaReservada + ", horasReserva=" + horasReserva + ", precioPorMinuto=" + precioPorMinuto + ", precioTotal=" + precioTotal + '}';
    }
    
    
    
}

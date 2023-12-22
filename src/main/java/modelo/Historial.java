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
public class Historial {
    private int id;
    private int idUsuario;
    private String matricula;
    private Date dia;
    private int tiempoReservado;
    private double precio;

    public Historial(int id, int idUsuario, String matricula, Date dia, int tiempoReservado, double precio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.matricula = matricula;
        this.dia = dia;
        this.tiempoReservado = tiempoReservado;
        this.precio = precio;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getTiempoReservado() {
        return tiempoReservado;
    }

    public void setTiempoReservado(int tiempoReservado) {
        this.tiempoReservado = tiempoReservado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Historial{" + "id=" + id + ", idUsuario=" + idUsuario + ", matricula=" + matricula + ", dia=" + dia + ", tiempoReservado=" + tiempoReservado + ", precio=" + precio + '}';
    }
  
    
}

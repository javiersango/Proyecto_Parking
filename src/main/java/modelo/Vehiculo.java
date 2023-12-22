/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Javier
 */
class Vehiculo {
    private int id;
    private int idUsuario;
    private String matricula;
    private boolean esCoche;

    public Vehiculo(int id, int idUsuario, String matricula, boolean esCoche) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.matricula = matricula;
        this.esCoche = esCoche;
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

    public boolean isEsCoche() {
        return esCoche;
    }

    public void setEsCoche(boolean esCoche) {
        this.esCoche = esCoche;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", idUsuario=" + idUsuario + ", matricula=" + matricula + ", esCoche=" + esCoche + '}';
    }
    
    
    
}

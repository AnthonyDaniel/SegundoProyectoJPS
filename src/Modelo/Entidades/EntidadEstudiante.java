
package Modelo.Entidades;

import java.io.Serializable;

public class EntidadEstudiante implements Serializable {
    
    private String cedula;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private int edad;
    
    private EntidadAusencia ausencia;
    
    private EntidadAsignatura asignatura;
    
    public EntidadEstudiante(){
    
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EntidadAusencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(EntidadAusencia ausencia) {
        this.ausencia = ausencia;
    }

    public EntidadAsignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(EntidadAsignatura asignatura) {
        this.asignatura = asignatura;
    }
    
}

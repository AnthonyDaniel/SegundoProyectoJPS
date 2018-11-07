
package Modelo.Entidades;

public class EntidadUsuarios {
    private String cedula;
    private String nombre;
    private String apellidos;
    private int edad;
    
    public EntidadUsuarios(){
        cedula = "";
        nombre = "";
        apellidos = "";
        edad = 0;
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
    
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}

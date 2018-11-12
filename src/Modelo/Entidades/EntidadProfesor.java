
package Modelo.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Profesor")
public class EntidadProfesor implements Serializable {
    
    private static final long serialVersionID=1L;
    
    @Id
    @Column(name="Cedula")
    private String cedula;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Apellidos")
    private String apellidos;
    
    @Column(name="Correo")
    private String correo;
    
    @Column(name="Telefono")
    private String telefono;
    
    @Column(name="Edad")
    private int edad;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdProfesor")
    @IndexColumn(name="idx")
    private List<EntidadAsignatura> asignatura;
    
    
    public EntidadProfesor(){
    
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

    public List<EntidadAsignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<EntidadAsignatura> asignatura) {
        this.asignatura = asignatura;
    }


}

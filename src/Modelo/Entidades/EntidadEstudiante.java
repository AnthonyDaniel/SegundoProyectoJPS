
package Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="Estudiante")
public class EntidadEstudiante implements Serializable {
    
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
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="estudiante") 
    private List<EntidadAusencia> cAusencia;
   @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="asignatura") 
    private List<EstudianteAsignatura> cEstudianteAsignatura;
    
   
    public EntidadEstudiante(){
        this.cEstudianteAsignatura = new ArrayList<EstudianteAsignatura>();
        this.cAusencia = new ArrayList<EntidadAusencia>();
        
        
    }

    //set y get
    
    
    
    
    
    
    
    public List<EntidadAusencia> getAusencia() {
        return cAusencia;
    }

    public void setAusencia(List<EntidadAusencia> ausencia) {
        this.cAusencia = ausencia;
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

    /**
     * @return the cEstudianteAsignatura
     */
    public List<EstudianteAsignatura> getcEstudianteAsignatura() {
        return cEstudianteAsignatura;
    }

    /**
     * @param cEstudianteAsignatura the cEstudianteAsignatura to set
     */
    public void setcEstudianteAsignatura(List<EstudianteAsignatura> cEstudianteAsignatura) {
        this.cEstudianteAsignatura = cEstudianteAsignatura;
    }

    

}

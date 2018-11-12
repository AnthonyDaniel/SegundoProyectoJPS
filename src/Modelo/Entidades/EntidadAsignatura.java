
package Modelo.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Asignatura")
public class EntidadAsignatura implements Serializable {
    
    @Id
    @Column(name="IdAsignatura")    
    private int idModulo;
    
    @Column(name="Nombre")
    private String nombre;
    
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="asignaturas")
    private Set<EntidadEstudiante> estudiantes=new HashSet();

    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private EntidadProfesor profesor;
    
    public EntidadAsignatura() {
        
    }

    public EntidadAsignatura(int idModulo, String nombre, EntidadProfesor profesor) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.profesor = profesor;

    }
   
    public int getIdAsignatura() {
        return idModulo;
    }

    public void setIdAsignatura(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Set<EntidadEstudiante> getEstudiante() {
        return estudiantes;
    }

    public void setEstudiante(Set<EntidadEstudiante> profesores) {
        this.estudiantes = profesores;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public Set<EntidadEstudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<EntidadEstudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public EntidadProfesor getProfesor() {
        return profesor;
    }

    public void setProfesor(EntidadProfesor profesor) {
        this.profesor = profesor;
    }
    
}

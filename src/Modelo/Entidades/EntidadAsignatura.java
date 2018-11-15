
package Modelo.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Asignatura")
public class EntidadAsignatura implements Serializable {
    
    @Id
    @Column(name="IdAsignatura")    
    private int idModulo;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Horario")
    private String horario;
 
    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private EntidadProfesor profesor;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdAsignatura")
    @IndexColumn(name="idx")
    private List<EntidadNota> nota;
    
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

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public EntidadProfesor getProfesor() {
        return profesor;
    }

    public void setProfesor(EntidadProfesor profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<EntidadNota> getNota() {
        return nota;
    }

    public void setNota(List<EntidadNota> nota) {
        this.nota = nota;
    }
    
}

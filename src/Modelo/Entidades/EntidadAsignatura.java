
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
    private String idModulo;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Horario")
    private String horario;
 
    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private EntidadProfesor profesor;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdAsignatura")
    private List<EntidadNota> nota;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdAsignatura")
    private List<EntidadAsistencia> asistencia;
    
    public EntidadAsignatura() {
        
    }


   
    public String getIdAsignatura() {
        return idModulo;
    }

    public void setIdAsignatura(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
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

    public List<EntidadAsistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<EntidadAsistencia> asistencia) {
        this.asistencia = asistencia;
    }
    
}

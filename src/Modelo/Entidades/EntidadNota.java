
package Modelo.Entidades;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="AsignaturaEstudiante")
public class EntidadNota implements Serializable{

    @Id
    @Column(name="INota")
    private String nota;
    
    @ManyToOne
    @JoinColumn(name="IdEstudiante")
    private EntidadEstudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name="IdAsignatura")
    private EntidadAsignatura asignatura;
 
    public EntidadNota(){
    
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
    
}

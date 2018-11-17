
package Modelo.Entidades;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="AsignaturaEstudiante")
public class EntidadNota implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;

    @GeneratedValue
    @Column(name="Nota")
    private double nota;
    
    @ManyToOne
    @JoinColumn(name="IdEstudiante")
    private EntidadEstudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name="IdAsignatura")
    private EntidadAsignatura asignatura;
 
    public EntidadNota(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    public EntidadEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EntidadEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    public EntidadAsignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(EntidadAsignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
}

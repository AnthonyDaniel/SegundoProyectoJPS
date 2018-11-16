
package Modelo.Entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Asistencia")
public class EntidadAsistencia implements Serializable {
    
    @Id
    @Column(name="Fecha")
    private String fecha;
    
    @ManyToOne
    @JoinColumn(name="IdAsignatura")    
    private EntidadAsignatura idAsistencia;

    @ManyToOne
    @JoinColumn(name="IdEstudiante")
    private EntidadEstudiante estudiante;
    
    public EntidadAsistencia() {
        
    }

    public EntidadAsignatura getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(EntidadAsignatura idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EntidadEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EntidadEstudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}

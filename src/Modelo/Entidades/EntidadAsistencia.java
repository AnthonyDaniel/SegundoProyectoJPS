
package Modelo.Entidades;

import Modelo.Entidades.EntidadEstudiante;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Asistencia")
public class EntidadAsistencia implements Serializable {
    
    @Id
    @Column(name="IdAsistencia")    
    private int idAsistencia;
    
    @Column(name="Fecha")
    private String fecha;
    
    @ManyToOne
    @JoinColumn(name="IdEstudiante")
    private EntidadEstudiante estudiante;
    
    public EntidadAsistencia() {
        
    }
    
    public EntidadAsistencia(int idCorreo,String fecha,EntidadEstudiante estudiante) {
        this.idAsistencia=idCorreo;
        this.fecha=fecha;
        this.estudiante=estudiante;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idCorreo) {
        this.idAsistencia = idCorreo;
    }

    public String getFecha() {
        return fecha;
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

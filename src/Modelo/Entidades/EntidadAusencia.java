
package Modelo.Entidades;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Ausencias")
public class EntidadAusencia implements Serializable{
    
    private static final long serialVersionID=1L;
    
    @Id
    @Column(name="IdAusencia")
    private String id;
    
    @Column(name="Fecha")
    private String fecha;
    
    @ManyToMany
    @JoinColumn(name="IdEstudiante")
    private EntidadEstudiante estudiante;
    
    public EntidadAusencia (){
    
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

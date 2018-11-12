
package Modelo.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EstudianteAsignatura")
public class EstudianteAsignatura implements Serializable{

    private static final long serialVersionID=1L;
    @ManyToOne
    private EntidadEstudiante estudiante;
    @Id
    @ManyToOne
    private EntidadAsignatura asignatura;
}

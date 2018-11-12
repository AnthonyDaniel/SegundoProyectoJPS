
package Modelo.Entidades;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="EstudianteAsignatura")
public class EstudianteAsignatura {
    
    @ManyToOne
    private EntidadEstudiante estudiante;
    @ManyToOne
    private EntidadAsignatura asignatura;
}

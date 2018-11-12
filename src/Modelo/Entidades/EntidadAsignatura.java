
package Modelo.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Asignatura")
public class EntidadAsignatura implements Serializable{

    private static final long serialVersionID=1L;
    
    @Id
    @Column(name="IdAsignatura")
    private int codigoAsignatura;
    
    @Column(name="Nombre")
    private String nombreAsignatura;
    
    @ManyToOne
    @JoinColumn(name="IdProfesor")
    private EntidadProfesor profesor;
   
    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="asignaturas")
    private Set<EntidadEstudiante> estudiante = new HashSet();
   
    public EntidadAsignatura(){
    
    
    }
    
    public int getCodigoAsignatura() {
        return codigoAsignatura;
    }
    public void setCodigoAsignatura(int codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }
    
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public EntidadProfesor getProfesor() {
        return profesor;
    }

    public void setProfesor(EntidadProfesor profesor) {
        this.profesor = profesor;
    }

    public Set<EntidadEstudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Set<EntidadEstudiante> estudiante) {
        this.estudiante = estudiante;
    }


    

}

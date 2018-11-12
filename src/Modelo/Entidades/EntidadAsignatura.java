
package Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private EntidadProfesor profesor;
   
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="asignatura") 
    private List<EstudianteAsignatura> cEstudianteAsignatura;
    
   
    public EntidadAsignatura(){
    this.cEstudianteAsignatura = new ArrayList<EstudianteAsignatura>();
    
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

    /**
     * @return the cEstudianteAsignatura
     */
    public List<EstudianteAsignatura> getcEstudianteAsignatura() {
        return cEstudianteAsignatura;
    }

    /**
     * @param cEstudianteAsignatura the cEstudianteAsignatura to set
     */
    public void setcEstudianteAsignatura(List<EstudianteAsignatura> cEstudianteAsignatura) {
        this.cEstudianteAsignatura = cEstudianteAsignatura;
    }

    


    

}

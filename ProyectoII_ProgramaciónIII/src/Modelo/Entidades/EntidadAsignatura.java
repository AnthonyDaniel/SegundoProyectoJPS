
package Modelo.Entidades;

import java.io.Serializable;

//@Entity //se le die que es una entidad
//@Table(name="asignaturas") //se crea la tabla en la DB

public class EntidadAsignatura implements Serializable{

   private static final long serialVersionID=1L;
       
//   @Id
   private int codigoAsignatura;
   private String nombreAsignatura;
   
//   @ManyToOne //se crea la relacion con profesor
//    private EntidadProfesor profesor;
   
//   @OneToMany //se crea la relacion con estudiante
//    private EntidadEstudiante estudiante;
   
    public EntidadAsignatura(){
        
    }
    
     /**
     * @return the codigoAsignatura
     */
    public int getCodigoAsignatura() {
        return codigoAsignatura;
    }

    /**
     * @param codigoAsignatura the codigoAsignatura to set
     */
    public void setCodigoAsignatura(int codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    /**
     * @return the nombreAsignatura
     */
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    /**
     * @param nombreAsignatura the nombreAsignatura to set
     */
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
}

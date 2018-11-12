
package Modelo.Entidades;

import java.io.Serializable;

public class EntidadAsignatura implements Serializable{

    private static final long serialVersionID=1L;
    
    private int codigoAsignatura;
    private String nombreAsignatura;
   
    private EntidadProfesor profesor;
   
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
}

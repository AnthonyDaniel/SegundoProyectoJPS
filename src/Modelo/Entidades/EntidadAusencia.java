
package Modelo.Entidades;

import java.io.Serializable;

public class EntidadAusencia implements Serializable{
    
    private String fecha;
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

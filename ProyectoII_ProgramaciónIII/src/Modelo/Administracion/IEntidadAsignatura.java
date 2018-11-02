
package Modelo.Administracion;

import java.util.ArrayList;

public interface IEntidadAsignatura {
   
    public boolean agregarAsignatura(EntidadAsignatura asignatura) throws Exception;
    public boolean modificarAsignatura(EntidadAsignatura asignatura) throws Exception;
    public boolean eliminarAsignatura(String codigo) throws Exception;
    public ArrayList<EntidadAsignatura>listar() throws Exception; //este metodo quizas sea map
}

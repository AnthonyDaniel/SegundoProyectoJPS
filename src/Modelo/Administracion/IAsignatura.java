
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import java.util.ArrayList;
import java.util.List;

public interface IAsignatura {
    public boolean agregarAsignatura(EntidadAsignatura asignatura) throws Exception;
    public boolean modificarAsignatura(EntidadAsignatura asignatura) throws Exception;
    public boolean eliminarAsignatura(String codigo) throws Exception;
    public List<EntidadAsignatura>listar(String nombreAsignatura) throws Exception; //este metodo quizas sea map
}

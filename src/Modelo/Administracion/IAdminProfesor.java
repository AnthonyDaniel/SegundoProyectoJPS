
package Modelo.Administracion;

import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import java.util.List;


public interface IAdminProfesor {
    public boolean agregarProfesor(EntidadProfesor profesor) throws Exception;
    public boolean modificarProfesor(EntidadProfesor profesor) throws Exception;
    public boolean eliminarProfesor(EntidadProfesor profesor) throws Exception;
    public List<EntidadProfesor>listar() throws Exception; 
    public List<EntidadProfesor>listarProfesor(int idProfesor) throws Exception;  
}


package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import java.util.List;

public interface IAdminEstudiante {
    public boolean agregarEstudiante(EntidadEstudiante asignatura) throws Exception;
    public boolean modificarEstudiante(EntidadEstudiante asignatura) throws Exception;
    public boolean eliminarEstudiante(String codigo) throws Exception;
    public List<EntidadEstudiante>listar() throws Exception; 
    public List<EntidadEstudiante>listarEstudiantes(int idEstudiante) throws Exception;  
}

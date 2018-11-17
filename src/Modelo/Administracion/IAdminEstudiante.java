
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import java.util.List;

public interface IAdminEstudiante {
    public boolean agregarEstudiante(EntidadEstudiante estudiante) throws Exception;
    public boolean modificarEstudiante(EntidadEstudiante estudiante) throws Exception;
    public boolean eliminarEstudiante(EntidadEstudiante estudiante) throws Exception;
    public List<EntidadEstudiante>listar() throws Exception; 
    public List<EntidadEstudiante>listarEstudiantes(int idEstudiante) throws Exception;
    public List<EntidadAsignatura>listarAsignaturas() throws Exception;
    public void ponerAsignatura(String idEst, String idAsig);
}

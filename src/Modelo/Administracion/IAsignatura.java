
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import java.util.ArrayList;
import java.util.List;

public interface IAsignatura {
    public boolean agregarAsignatura(EntidadAsignatura asignatura);
    public boolean modificarAsignatura(EntidadAsignatura asignatura);
    public boolean eliminarAsignatura(String codigo);
    public List<EntidadAsignatura>listar();
}

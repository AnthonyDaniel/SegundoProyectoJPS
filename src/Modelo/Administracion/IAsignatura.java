
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import java.util.ArrayList;
import java.util.List;

public interface IAsignatura {
    public boolean validarDatos();
    public boolean agregarAsignatura(EntidadAsignatura asignatura);
    public boolean modificarAsignatura(EntidadAsignatura asignatura);
    public boolean eliminarAsignatura(EntidadAsignatura asignatura);
    public List<EntidadAsignatura>listar();
}


package Modelo.Administracion;

import java.util.ArrayList;

public interface IEntidadUsuarios {
    
    public boolean agregarUsuario(EntidadUsuarios usuario) throws Exception;
    public boolean modificarUsuario(EntidadUsuarios usuario) throws Exception;
    public boolean eliminarUsuario(String id) throws Exception;
    public ArrayList<EntidadUsuarios>listar() throws Exception; //este metodo quizas sea map
}

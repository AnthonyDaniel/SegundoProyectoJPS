
package Modelo.Administracion;

import java.util.ArrayList;

public interface IEntidadUsuarios {
    
    public boolean agregarUsuario(EntidadPersona usuario) throws Exception;
    public boolean modificarUsuario(EntidadPersona usuario) throws Exception;
    public boolean eliminarUsuario(String id) throws Exception;
    public ArrayList<EntidadPersona>listar() throws Exception; //este metodo quizas sea map
}

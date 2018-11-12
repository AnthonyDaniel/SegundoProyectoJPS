
package Controlador;

import Vista.Interfaz;
import Vista.InterfazAdministracion;
import Vista.Login;

public class ControladorPrincipal {
 
    public Interfaz interfaz;
    private ControladorLogin controladorLogin;
    private Login login;
    private InterfazAdministracion administracion;
    private ControladorAsignaturas controladorAsignaturas;
    
    public ControladorPrincipal(){
        administracion = new InterfazAdministracion();
        login = new Login();
        interfaz = new Interfaz();
        controladorLogin = new ControladorLogin(interfaz,login);
        controladorAsignaturas = new ControladorAsignaturas(administracion);
        
        
    }
    
}

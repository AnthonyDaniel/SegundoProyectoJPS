
package Controlador;

import Vista.Interfaz;
import Vista.Login;

public class ControladorPrincipal {
 
    public Interfaz interfaz;
    private ControladorLogin controladorLogin;
    private Login login;
    
    public ControladorPrincipal(){
    
        login = new Login();
        interfaz = new Interfaz();
        controladorLogin = new ControladorLogin(interfaz,login);
        
    }
    
}

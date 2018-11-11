
package Controlador;

import Vista.InterfazPrincipal;
import Vista.Login.PanelLogin;

public class ControladorPrincipal {
     
    private InterfazPrincipal interfazPrincipal;    
    private ControladorLogin controladorLogin;

    public ControladorPrincipal(){
        interfazPrincipal = new InterfazPrincipal();
        controladorLogin = new ControladorLogin(interfazPrincipal);
    }
   
}

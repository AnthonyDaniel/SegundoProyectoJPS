
package Controlador;

import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.InterfazAdministracion;
import Vista.Login;

public class ControladorPrincipal {
 
    public Interfaz interfaz;
    private ControladorLogin controladorLogin;
    private Login login;
    private InterfazAdministracion administracion;
    private ControladorAsignaturas controladorAsignaturas;
    private ILogin loginMetodos;
    
    public ControladorPrincipal(){
        Vista();
        Modelo();
        Controladores();
    }
    
    public final void Vista(){
         //Vista
        login = new Login();
        interfaz = new Interfaz();
    }
    public final void Modelo(){
        //Modelo
        loginMetodos = new LoginMetodos();
    }
    public final void Controladores(){
       //Controladores Inyeccion de codigo
        administracion = new InterfazAdministracion();
        controladorLogin = new ControladorLogin(interfaz,login, loginMetodos);
        controladorAsignaturas = new ControladorAsignaturas(administracion);
    }
  
}

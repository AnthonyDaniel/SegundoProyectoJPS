
package Controlador;

import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.Administracion.InterfazAdministracion;
import Vista.Estudiante.InterfazEstudiante;
import Vista.Login.InterfazLogin;
import Vista.Profesor.InterfazProfesor;

public class ControladorPrincipal {
    
    //Vista
    public Interfaz interfaz;
    public InterfazLogin login;
    public InterfazAdministracion administracion;
    public InterfazProfesor profesor;
    public InterfazEstudiante estudiante;
    
    //Modelo
    private ILogin loginMetodos;
    private EntidadAsignatura asignatura;
    private IAsignatura interfaceAsignatura;
    
    //Controladores
    private ControladorLogin controladorLogin;
    private ControladorAsignaturas controladorAsignaturas;
    private ControladorProfesor controlProfesor;
    
    
    public ControladorPrincipal(){
        Vista();
        Modelo();
        Controladores();
    }
    
    public final void Vista(){
         //Vista
        login = new InterfazLogin();
        interfaz = new Interfaz();
        estudiante = new InterfazEstudiante();
        profesor = new InterfazProfesor();
        administracion = new InterfazAdministracion();
        
    }
    public final void Modelo(){
        //Modelo
        loginMetodos = new LoginMetodos();
        interfaceAsignatura = new ContenedorAsignatura();
        asignatura=new EntidadAsignatura();
    }
    public final void Controladores(){
       //Controladores Inyeccion de codigo
        controladorLogin = new ControladorLogin(interfaz,login, loginMetodos, administracion, profesor, estudiante);
        controladorAsignaturas = new ControladorAsignaturas(administracion,interfaceAsignatura,asignatura);
        controlProfesor = new ControladorProfesor();
    }
  
}

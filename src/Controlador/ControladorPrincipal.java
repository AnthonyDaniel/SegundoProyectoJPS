
package Controlador;

import Modelo.Administracion.ContenedorAdminEstudiante;
import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.Administracion.InterfazAdministracion;
import Vista.Estudiante.InterfazEstudiante;
import Vista.Login.InterfazLogin;
import Vista.Profesor.InterfazProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

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
    private IAdminEstudiante adminEstudiante;
    private EntidadEstudiante entidadEstudiante;
    //Controladores
    private ControladorLogin controladorLogin;
    private ControladorAdminAsignatura controladorAsignaturas;
    private ControladorProfesor controlProfesor;
    private ControladorAdminEstudiante controladorAdminEstudiantes;
    private ControladorEstudiante controladorEstudiante;
    
    
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
        adminEstudiante = new ContenedorAdminEstudiante();
        asignatura=new EntidadAsignatura();
        entidadEstudiante = new EntidadEstudiante();
        
    }
    public final void Controladores(){
       //Controladores Inyeccion de codigo
        controladorLogin = new ControladorLogin(this,interfaz,login, loginMetodos, administracion, profesor, estudiante);
      
    }
  
    public void iniciarLosConstructores(){
        //Se inicializa en login
                if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "Administrador");
                    controladorAsignaturas = new ControladorAdminAsignatura(administracion,interfaceAsignatura,asignatura);
                    controladorAdminEstudiantes = new ControladorAdminEstudiante(administracion,adminEstudiante,entidadEstudiante);
                    
                }else if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Profesor")){
                    JOptionPane.showMessageDialog(null, "Entre Profesortes");
                    controlProfesor = new ControladorProfesor(interfaz);
                
                }else if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Estudiante")){
                    JOptionPane.showMessageDialog(null, "Entre Estudiantes");
                    controladorEstudiante = new ControladorEstudiante();
                    
                }
                  
    }
}

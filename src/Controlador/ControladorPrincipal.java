
package Controlador;

import Modelo.Administracion.ContenedorAdminEstudiante;
import Modelo.Administracion.ContenedorAdminProfesor;
import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAdminProfesor;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Administracion.AgregarAsignatura;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.AgregarProfesor;
import Vista.Administracion.Estudiantes;
import Vista.Interfaz;
import Vista.Administracion.InterfazAdministracion;
import Vista.Administracion.Profesores;
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
    public InterfazEstudiante estudiante;
    public AgregarAsignatura agregarAsignatura;
    public Estudiantes panelEstudiantes;
    public AgregarEstudiante agregarEstudiante;
     public Profesores panelProfesores;
    public AgregarProfesor agregarProfesor;
    //Modelo
    private ILogin loginMetodos;
    private EntidadAsignatura asignatura;
    private IAsignatura interfaceAsignatura;
    private IAdminEstudiante adminEstudiante;
     private IAdminProfesor adminProfesor;
    private EntidadEstudiante entidadEstudiante;
     private EntidadProfesor entidadProfesor;
    //Controladores
    private ControladorLogin controladorLogin;
    private ControladorAdminAsignatura controladorAsignaturas;
    private ControladorProfesor controlProfesor;
    private ControladorAdminEstudiante controladorAdminEstudiantes;
    private ControladorAdminProfesor controladorAdminProfesores;
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
        administracion = new InterfazAdministracion();
        agregarAsignatura = new AgregarAsignatura();
        panelEstudiantes = new Estudiantes(controladorAdminEstudiantes);
        agregarEstudiante = new AgregarEstudiante();
        panelProfesores= new Profesores();
        agregarProfesor = new AgregarProfesor();
        
    }
    public final void Modelo(){
        //Modelo
        loginMetodos = new LoginMetodos();
        interfaceAsignatura = new ContenedorAsignatura(agregarAsignatura);
        adminEstudiante = new ContenedorAdminEstudiante(panelEstudiantes, agregarEstudiante);
        adminProfesor = new ContenedorAdminProfesor(panelProfesores, agregarProfesor);
        asignatura=new EntidadAsignatura();
        entidadEstudiante = new EntidadEstudiante();
         entidadProfesor = new EntidadProfesor();
    }
    public final void Controladores(){
       //Controladores Inyeccion de codigo
        controladorLogin = new ControladorLogin(this,interfaz,login, loginMetodos, administracion,estudiante);
      
    }
  
    public void iniciarLosConstructores(){
        //Se inicializa en login
                if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "Administrador");
                    controladorAsignaturas = new ControladorAdminAsignatura(administracion,interfaceAsignatura,asignatura,agregarAsignatura);
                    controladorAdminEstudiantes = new ControladorAdminEstudiante(administracion,adminEstudiante,entidadEstudiante,panelEstudiantes, agregarEstudiante);
                     controladorAdminProfesores= new ControladorAdminProfesor(administracion,adminProfesor,entidadProfesor,panelProfesores, agregarProfesor);
                }else if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Profesor")){
                    controlProfesor = new ControladorProfesor(interfaz);
                
                }else if(loginMetodos.verificarQueTipoDeUsuarioEs().equals("Estudiante")){
                    JOptionPane.showMessageDialog(null, "Entre Estudiantes");
                    controladorEstudiante = new ControladorEstudiante(interfaz, estudiante);
                    
                }
                  
    }
}

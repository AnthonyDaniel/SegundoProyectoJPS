
package Controlador;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.Administracion.InterfazAdministracion;
import Vista.Estudiante.InterfazEstudiante;
import Vista.Login.InterfazLogin;
import Vista.Profesor.InterfazProfesor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ControladorPrincipal {
    
    //Vista
    public Interfaz interfaz;
    public InterfazLogin login;
    public InterfazAdministracion administracion;
    public InterfazProfesor profesor;
    public InterfazEstudiante estudiante;
    
    //Modelo
    private ILogin loginMetodos;
    
    //Controladores
    private ControladorLogin controladorLogin;
    private ControladorAsignaturas controladorAsignaturas;
    
    
    public ControladorPrincipal(){
        Vista();
        Modelo();
        Controladores();
        Pruebas();
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
    }
    public final void Controladores(){
       //Controladores Inyeccion de codigo
        controladorLogin = new ControladorLogin(interfaz,login, loginMetodos, administracion, profesor, estudiante);
        controladorAsignaturas = new ControladorAsignaturas(administracion);
    }
    private void Pruebas(){
    
        Session session = new HibernateUtil().buildSessionFactory().openSession();
        
        session.beginTransaction();
        

            EntidadProfesor profesor;
            
            
            profesor = (EntidadProfesor) session.createCriteria(EntidadProfesor.class).uniqueResult();
            
        JOptionPane.showMessageDialog(null, profesor.getContrasena());
    
    }
   
}

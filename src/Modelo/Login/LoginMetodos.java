package Modelo.Login;

import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class LoginMetodos implements ILogin{
    
    public HibernateUtil hibernateUtil;
    private String tipo;
    
    public LoginMetodos(){
    
    }

    public boolean verificarUsuario(String cedula, String contrasena) {
        
        if(cedula.equals("admin") && contrasena.equals("admin")){
            tipo = "Administrador";
            return true;
        }else{
        
            Session sesion = new HibernateUtil().buildSessionFactory().openSession();
        
            sesion.beginTransaction();
        
            List<EntidadEstudiante> estudiante;
            List<EntidadProfesor> profesor;
            
            estudiante = sesion.createCriteria(EntidadEstudiante.class).list();
            
            for(EntidadEstudiante e : estudiante){
            
                if(e.getId().equals(cedula) && e.getContrasena().equals(contrasena)){
                    tipo = "Estudiante";
                    sesion.close();
                    return true;
                    
                }
            
            }
            
            profesor = sesion.createCriteria(EntidadProfesor.class).list();
           
            for(EntidadProfesor e : profesor){
                
                  if(e.getId().equals(cedula) && e.getContrasena().equals(contrasena)){
                    tipo = "Profesor";  
                    sesion.close();  
                    return true;
                    
                }
            
            }
             sesion.close();
        }
        
       
        return false;
    
    }

    @Override
    public String verificarQueTipoDeUsuarioEs() {
        return tipo;
    }
    
}

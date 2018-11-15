
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContenedorAsignatura implements IAsignatura{
    
    
    
    public ContenedorAsignatura(){
        
    }
    
    @Override
    public boolean agregarAsignatura(EntidadAsignatura asignatura){
      
      Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
  
      session.save(asignatura);
      
      session.getTransaction().commit();
      session.close();
      
      exito=true;
       }catch(Exception ex){
             exito=false;
             JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", 
             "WARNING", JOptionPane.WARNING_MESSAGE);
       }
      
         return exito;
    }

    @Override
    public List<EntidadAsignatura> listar(){
      
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadAsignatura> datos;
       
        datos=session.createCriteria(EntidadAsignatura.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        return datos;
    }

    @Override
    public boolean modificarAsignatura(EntidadAsignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAsignatura(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


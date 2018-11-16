
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarAsignatura;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContenedorAsignatura implements IAsignatura{
    
    private AgregarAsignatura aa;
    
    public ContenedorAsignatura(AgregarAsignatura _aa){
     
        aa = _aa;
        
    }
    
    public boolean validarDatos(){
    
        try{
        if(!aa.jTextFieldNombre.getText().equals("") && !aa.jTextFieldId.getText().equals("") 
                && !aa.jTextFieldHorario.getText().equals("") && !aa.jComboBoxProfesores.getSelectedItem().equals("")){
            return true;
        }
        
        }catch(Exception e){}
        return false;
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
        
      Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
  
      session.saveOrUpdate(asignatura);
      
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
    public boolean eliminarAsignatura(EntidadAsignatura asignatura) {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 

      session.delete(asignatura);
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


}



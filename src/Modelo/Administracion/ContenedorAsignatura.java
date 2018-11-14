
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ContenedorAsignatura implements IAsignatura{

    @Override
    public boolean agregarAsignatura(EntidadAsignatura asignatura) throws Exception {
      
      Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
      //insertar una entidad
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
    public boolean modificarAsignatura(EntidadAsignatura asignatura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAsignatura(String codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadAsignatura> listar(String nombreAsignatura) throws Exception {
        
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();

        SQLQuery consulta =  session.createSQLQuery("SELECT * FROM colegiomav WHERE asignatura= "+nombreAsignatura);

        List datos = consulta.list();
        
        session.getTransaction().commit();
        session.close();
        
        return datos;
    }
    
}


package Modelo.Administracion;

import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarProfesor;
import Vista.Administracion.Profesores;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ContenedorAdminProfesor implements IAdminProfesor{

    private Profesores es;
    private AgregarProfesor ae;
    
    public ContenedorAdminProfesor(Profesores _es, AgregarProfesor _ae){
        es=_es;
        ae=_ae;
    }

    @Override
    public boolean agregarProfesor(EntidadProfesor profesor) throws Exception {
      Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
      //insertar una entidad
      session.save(profesor);
      
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
    public boolean modificarProfesor(EntidadProfesor profesor) throws Exception {
            Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
  
      session.saveOrUpdate(profesor);
      
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
    public boolean eliminarProfesor(EntidadProfesor profesor) throws Exception {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 

      session.delete(profesor);
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
    public List<EntidadProfesor> listar() throws Exception {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadProfesor> datos;
       
        datos=session.createCriteria(EntidadProfesor.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        return datos;
    }

    @Override
    public List<EntidadProfesor> listarProfesor(int idProfesor) throws Exception {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List<EntidadProfesor> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from profesor where Id = "+idProfesor);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
       
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
    
   
    
}


package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.Estudiantes;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ContenedorAdminEstudiante implements IAdminEstudiante{

    private Estudiantes es;
    private AgregarEstudiante ae;
    
    public ContenedorAdminEstudiante(Estudiantes _es, AgregarEstudiante _ae){
        es=_es;
        ae=_ae;
    }
  @Override
    public boolean agregarEstudiante(EntidadEstudiante estudiante) throws Exception {
      Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
      //insertar una entidad
      session.save(estudiante);
      
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
    public boolean modificarEstudiante(EntidadEstudiante estudiante) throws Exception {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 
  
      session.saveOrUpdate(estudiante);
      
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
    public boolean eliminarEstudiante(EntidadEstudiante estudiante) throws Exception {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
      session.beginTransaction();
      boolean exito;
        
      try{ 

      session.delete(estudiante);
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
    public List<EntidadEstudiante> listar() throws Exception {
         
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadEstudiante> datos;
       
        datos=session.createCriteria(EntidadEstudiante.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        return datos;
    }

    @Override
    public List<EntidadEstudiante> listarEstudiantes(int idEstudiante) throws Exception {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List<EntidadEstudiante> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from estudiante where Cedula = "+idEstudiante);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
       
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }

    @Override
    public List<EntidadAsignatura> listarAsignaturas() throws Exception {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadAsignatura> datos;
       
        datos=session.createCriteria(EntidadAsignatura.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        return datos;
    }

    @Override
    public void ponerAsignatura(String idEst, String idAsig) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();      
        
        

        SQLQuery consulta =  session.createSQLQuery("insert into asignaturaEstudiante (IdAsignatura,IdEstudiante) values ('"+idAsig+"','"+idEst+"')");

        consulta.executeUpdate();    
        
        session.getTransaction().commit();
        session.close();
    }
}
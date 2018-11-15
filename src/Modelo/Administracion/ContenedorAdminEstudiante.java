
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.Estudiantes;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ContenedorAdminEstudiante implements IAdminEstudiante{

    private Estudiantes es;
    
    public ContenedorAdminEstudiante(Estudiantes _es){
        es=_es;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarEstudiante(String codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        SQLQuery consulta =  session.createSQLQuery("select * from estudiante where IdEstudiante = "+idEstudiante);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
       
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
}
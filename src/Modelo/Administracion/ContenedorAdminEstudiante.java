
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class ContenedorAdminEstudiante implements IAdminEstudiante{

    @Override
    public boolean agregarEstudiante(EntidadEstudiante estudiante) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}

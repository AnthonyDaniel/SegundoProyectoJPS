
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class ContenedorEstudiante implements IEstudiante{

    Session session = new HibernateUtil().buildSessionFactory().openSession();  
    
    public ContenedorEstudiante(){
        
    }
    @Override
    public List<EntidadEstudiante> listar() throws Exception {
       List<EntidadEstudiante> estudiante;
       
       session.beginTransaction();
        
        estudiante= session.createCriteria(EntidadAsignatura.class).list();
        
        return estudiante;
    }
    
}

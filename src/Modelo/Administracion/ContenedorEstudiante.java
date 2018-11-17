/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadAsistencia;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Edris Jose Rios
 */
public class ContenedorEstudiante implements IEstudiante {

    @Override
    public List listarEstudiantes(String _idAsginatura) {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List<EntidadEstudiante> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asignaturaestudiante where IdAsignatura = "+_idAsginatura);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
        
        
        session.getTransaction().commit();
        
        return lista;
    }

    @Override
    public List listarProfesores(String _idAsignatura) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadProfesor> datos;
       
        datos=session.createCriteria(EntidadProfesor.class).list();
        
        session.getTransaction().commit();
        session.close();
        
        JOptionPane.showMessageDialog(null, datos.get(0).getNombre());
        
        return datos;
        
    }

    @Override
    public List listarNotas(String idEstudiante, String idAsignatura) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List<EntidadEstudiante> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asignaturaestudiante where IdEstudiante = '"+ idEstudiante+"'"+"and IdAsignatura ='"+ idAsignatura+"'");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
       
        
        session.getTransaction().commit();
        
        return lista;
    }

    @Override
    public List listarAsistencias(String id, String idAsig) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List <EntidadAsistencia> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asistencia where IdEstudiante ='"+ id+"'"+"and IdAsignatura ='"+idAsig+"'");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
       
        session.getTransaction().commit();
        
        return lista;
    }

    @Override
    public List listarAsignaturas(String id) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asignaturaestudiante where IdEstudiante = '"+ id+"'");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
       
        
        session.getTransaction().commit();
        
        return lista;
    }
    
}

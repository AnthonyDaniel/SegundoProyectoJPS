/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadEstudiante;
import Modelo.Hibernate.HibernateUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Edris Jose Rios
 */
public class ContenedorEstudiante implements IEstudiante {

    @Override
    public List listarEstudiantes(int _idAsginatura) {
         Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List<EntidadEstudiante> lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asignaturaestudiante where IdAsignatura = "+_idAsginatura);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
        for(Object lib:lista){
            Map tupla = (Map)lib;
            System.out.println(tupla.get("IdEstudiante") +" "+tupla.get("IdAsignatura"));
            System.out.println("-------");
        }
        
        session.getTransaction().commit();
        
        return lista;
    }

    @Override
    public List listarProfesores(int _idAsignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

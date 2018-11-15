/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadAusencia;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Mauricio
 */
public class ContenedorProfesor implements IProfesor{

    @Override
    public List<EntidadEstudiante> listarEstudiantes(int _idAsignatura) {
//        Session session = new HibernateUtil().buildSessionFactory().openSession();        
//        session.beginTransaction();
//        
//        List<EntidadEstudiante> lista;
//
//        SQLQuery consulta =  session.createSQLQuery("select * from assignaturaestudiante where IdAsignatura = "+_idAsignatura);
//
//        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//        
//        lista = consulta.list();
//        
//        for(Object lib:lista){
//            Map tupla = (Map)lib;
//            System.out.println(tupla.get("IdEstudiante") +" "+tupla.get("IdAsignatura"));
//            System.out.println("-------");
//        }
//        
//        session.getTransaction().commit();
//        //session.close();
        return null;
    }

    @Override
    public List<EntidadAsignatura> listarAsignaturas(int _idProf) {
        
        return null;
    }

    @Override
    public List<EntidadProfesor> listarProfesores() {
        return null;
    }

    @Override
    public void ponerNota() {
        
    }

    @Override
    public void ponerFalta() {
        
    }

    @Override
    public void modificarNota() {
        
    }

    @Override
    public void modificarFalta() {
        
    }

    @Override
    public List<EntidadAusencia> listarAusencias(int _cedEst, int _idAsignatura) {
        return null;
    }
    
}

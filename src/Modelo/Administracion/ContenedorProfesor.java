/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Mauricio
 */
public class ContenedorProfesor implements IProfesor{

    @Override
    public ArrayList<EntidadEstudiante> listarEstudiantes(int _idAsignatura) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select IdEstudiante from asignaturaestudiante where IdAsignatura = "+_idAsignatura);

        
        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
       
        
        Object[] idsEst = new Object[lista.size()];
        
        int n= 0;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            idsEst[n] = tupla.get("IdEstudiante");
            n++;
        }
        
        ArrayList<EntidadEstudiante> listEst = new ArrayList<>();
        EntidadEstudiante student;
        
        List lista2;
        
        SQLQuery consulta2;
        for(int i=0; i < lista.size();i++){
            consulta2 =  session.createSQLQuery("select Cedula, Nombre, Apellido from estudiante where Cedula = '"+idsEst[i]+"'");
            consulta2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);        
            lista2 = consulta2.list();
            for(Object lib:lista2){
                student = new EntidadEstudiante();
                Map tupla = (Map)lib;
                student.setId((String) tupla.get("Cedula"));
                student.setNombre((String) tupla.get("Nombre"));
                student.setApe1((String) tupla.get("Apellido"));
                listEst.add(student);
            }            
        }        
        session.getTransaction().commit();
        session.close();
        return listEst;
    }

    @Override
    public List listarAsignaturas(String _idProf) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select * from asignatura where IdProfesor = '"+_idProf+"'");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();       
        
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }

    @Override
    public List listarProfesores() {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select * from profesor");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();       
        
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }

    @Override
    public void ponerNota(double _nota, String _idEst, int _idAsig) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();        

        SQLQuery consulta =  session.createSQLQuery("update asignaturaestudiante set Nota="+_nota+" where IdEstudiante= '"+_idEst+"' and IdAsignatura = "+_idAsig);

        consulta.executeUpdate();    
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void ponerFalta() {
        
    }

    @Override
    public double obtenerNota(String _idEst, int _idAsig) {
        double nota = 0;
        
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select Nota from asignaturaestudiante where IdEstudiante = '"+_idEst+"' and IdAsignatura = "+_idAsig);

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();  
       
        for(Object lib:lista){
            Map tupla = (Map)lib;
            nota = (double) tupla.get("Nota");
        }
        
        session.getTransaction().commit();
        session.close();       
        
        return nota;
    }

    @Override
    public void modificarFalta() {
        
    }

    @Override
    public List listarAusencias(int _cedEst, int _idAsignatura) {
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
        
        List lista;

        SQLQuery consulta =  session.createSQLQuery("select * from profesor");

        consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        
        lista = consulta.list();
        
        System.out.println("Lista profesor");
        for(Object lib:lista){
            Map tupla = (Map)lib;
            System.out.println(tupla.get("Id")+" "+tupla.get("nombre") +" "+tupla.get("ape1")+" "+tupla.get("ape2"));
            System.out.println("-------");
        }
        
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
    
}

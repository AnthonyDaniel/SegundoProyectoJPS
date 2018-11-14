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

        SQLQuery consulta =  session.createSQLQuery("select * from where assignaturaEstudiante = "+_idAsignatura);

        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList<EntidadAsignatura> listarAsignaturas(int _idProf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EntidadProfesor> listarProfesores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ponerNota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ponerFalta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarNota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarFalta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EntidadAusencia> listarAusencias(int _cedEst, int _idAsignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

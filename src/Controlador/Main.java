package Controlador;

import Modelo.Entidades.EntidadAsistencia;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) {
        
        new ControladorPrincipal();
        
        EntidadEstudiante estudiante = new EntidadEstudiante(10, "Laura", "Vivó");
        List<EntidadAsistencia> asistencia = new ArrayList<>();
        asistencia.add(new EntidadAsistencia(3, "2019", estudiante));
        asistencia.add(new EntidadAsistencia(2, "2012", estudiante));
        asistencia.add(new EntidadAsistencia(1, "2033", estudiante));

        estudiante.setAsistencia(asistencia);

        EntidadEstudiante estudiante1 = new EntidadEstudiante(13, "Ana Isabel", "Perez");
        EntidadEstudiante estudiante2 = new EntidadEstudiante(14, "Francisco", "Moya");

        EntidadProfesor profesor = new EntidadProfesor(10, "Laura", "Vivó", "López");
        
        EntidadAsignatura asignatura1 = new EntidadAsignatura(4, "Matematicas",profesor);
        EntidadAsignatura asignatura2 = new EntidadAsignatura(5, "Programación",profesor);
        EntidadAsignatura asignatura3 = new EntidadAsignatura(6, "Lenguaje de marcas",profesor);

        estudiante1.getAsignatura().add(asignatura1);
        estudiante1.getAsignatura().add(asignatura2);
        estudiante2.getAsignatura().add(asignatura3);

        asignatura1.getEstudiante().add(estudiante1);
        asignatura2.getEstudiante().add(estudiante1);
        asignatura3.getEstudiante().add(estudiante2);
        

        List<EntidadAsignatura> correosElectronicos = new ArrayList<>();
        correosElectronicos.add(new EntidadAsignatura(3, "laura@yahoo.com", profesor));
        correosElectronicos.add(new EntidadAsignatura(2, "laura@hotmail.com", profesor));
        correosElectronicos.add(new EntidadAsignatura(1, "laura@gmail.com", profesor));

        profesor.setCorreosElectronicos(correosElectronicos);

        
        //Así Se llama La class HibernateUtil();
        Session session = new HibernateUtil().buildSessionFactory().openSession();
        

        session.beginTransaction();

        session.save(profesor);

        session.save(estudiante1);
        session.save(estudiante2);
        session.save(estudiante);

        session.getTransaction().commit();
        session.close();

//        SessionFactory sessionFactory;
////
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

//        EntidadEstudiante estudiante = new EntidadEstudiante(10, "Laura", "Vivó");
//        List<EntidadAsistencia> asistencia = new ArrayList<>();
//        asistencia.add(new EntidadAsistencia(3, "2019", estudiante));
//        asistencia.add(new EntidadAsistencia(2, "2012", estudiante));
//        asistencia.add(new EntidadAsistencia(1, "2033", estudiante));
//
//        estudiante.setAsistencia(asistencia);
//
//        EntidadEstudiante estudiante1 = new EntidadEstudiante(13, "Ana Isabel", "Perez");
//        EntidadEstudiante estudiante2 = new EntidadEstudiante(14, "Francisco", "Moya");
//
//        EntidadProfesor profesor = new EntidadProfesor(10, "Laura", "Vivó", "López");
//        
//        EntidadAsignatura asignatura1 = new EntidadAsignatura(4, "Matematicas",profesor);
//        EntidadAsignatura asignatura2 = new EntidadAsignatura(5, "Programación",profesor);
//        EntidadAsignatura asignatura3 = new EntidadAsignatura(6, "Lenguaje de marcas",profesor);
//
//        estudiante1.getAsignatura().add(asignatura1);
//        estudiante1.getAsignatura().add(asignatura2);
//        estudiante2.getAsignatura().add(asignatura3);
//
//        asignatura1.getEstudiante().add(estudiante1);
//        asignatura2.getEstudiante().add(estudiante1);
//        asignatura3.getEstudiante().add(estudiante2);
//        
//
//        List<EntidadAsignatura> correosElectronicos = new ArrayList<>();
//        correosElectronicos.add(new EntidadAsignatura(3, "laura@yahoo.com", profesor));
//        correosElectronicos.add(new EntidadAsignatura(2, "laura@hotmail.com", profesor));
//        correosElectronicos.add(new EntidadAsignatura(1, "laura@gmail.com", profesor));
//
//        profesor.setCorreosElectronicos(correosElectronicos);
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.save(profesor);
//
//        session.save(estudiante1);
//        session.save(estudiante2);
//        session.save(estudiante);

//        session.getTransaction().commit();
//        session.close();

    }
}

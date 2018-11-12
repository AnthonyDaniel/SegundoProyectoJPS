
package Modelo.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFact=buildSessionFactory(); 

       public static SessionFactory buildSessionFactory(){
            try{

                Configuration config = new Configuration();
                config.configure("Hibernate.cnf.xml");
                ServiceRegistry serviceReg=new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

                SessionFactory sf=config.buildSessionFactory(serviceReg);
                return sf;

            }catch(Throwable err){
            err.printStackTrace();
            System.out.println("Error al crear sesion en la BD");

            throw new ExceptionInInitializerError();
           }
    }

    public static SessionFactory getSession(){
        return sessionFact;
    }
}

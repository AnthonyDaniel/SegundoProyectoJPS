
package Modelo;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
    private static final SessionFactory sessionFact = buildSessionFactory() ;

    public HibernateUtil(){
    
    }
    
    public static SessionFactory buildSessionFactory() {
    
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cnf.xml");
            ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sf = config.buildSessionFactory(serviceReg);
            return sf;
        } catch (Throwable err) {
            System.err.print(err);
            err.printStackTrace();
            JOptionPane.showMessageDialog(null, err);
            throw new ExceptionInInitializerError();
            
        } 
    }
    public static SessionFactory getSessionFact() {
        return sessionFact;
    }
}

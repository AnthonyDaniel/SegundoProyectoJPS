
package Controlador;

import Modelo.Hibernate.HibernateUtil;
import org.hibernate.Session;

public class Main {
    
    public static void main(String args[]){
    
        Session  sesion = HibernateUtil.getSession().getCurrentSession();
            
        sesion.beginTransaction();
    }
    
}

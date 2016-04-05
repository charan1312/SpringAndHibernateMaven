package com.javat.mypackage;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class StoreData {

    public static void main(String[] args) {
        
        Configuration cfg =  new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sFactory = cfg.buildSessionFactory();
        
        Session session = sFactory.openSession();
        
        org.hibernate.Transaction t = session.beginTransaction();
        
        Employee e1 = new Employee();
        e1.setId(99);
        e1.setFirstName("Charan Thej");
        e1.setLastName("Aware");
        
        session.persist(e1);
        
        t.commit();
        session.close();
        System.out.println("Object saved in DB");
    }
}

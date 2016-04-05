package com.javat.mypackage;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class StoreDataWithAnnot {

    static class paremp {
        int id;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getFname() {
            return fname;
        }
        public void setFname(String fname) {
            this.fname = fname;
        }
        String fname;
        public paremp(){
            
        }
        public paremp(int id, String fname) {
            super();
            this.id = id;
            this.fname = fname;
        }
        
    }
    public static void main(String[] args) {
        /*
        Configuration cfg =  new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sFactory = cfg.buildSessionFactory();
        
        Session session = sFactory.openSession();
        */
        Session session2 = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        
       /* Transaction t = session2.beginTransaction();
        
        EmployeeWithAnnotation e1 = new EmployeeWithAnnotation();
        e1.setId(199);
        e1.setFirstName("Rimpy");
        e1.setLastName("Bharot");
        session2.persist(e1);
        
        EmployeeWithAnnotation e2 = new EmployeeWithAnnotation();
        e2.setId(210);
        e2.setFirstName("Simple");
        e2.setLastName("Bharot");
        session2.persist(e2);
        
        t.commit();
       */ 
        
        //Sum of a field
        Query q = session2.createQuery("select sum(id) from EmployeeWithAnnotation");
        List<EmployeeWithAnnotation> sumlist = q.list();
        
        Iterator<EmployeeWithAnnotation> sumiter = sumlist.iterator();
        
        while(sumiter.hasNext()) {
            System.out.println(sumiter.next());
        }
        
        //Count of a field
        //max
        //min
        Query q1 = session2.createQuery("select count(id) from EmployeeWithAnnotation");
        List<EmployeeWithAnnotation> countlist = q1.list();
        
        Iterator<EmployeeWithAnnotation> countitr = countlist.iterator();
        
        while(countitr.hasNext()) {
            System.out.println(countitr.next());
        }

        //fetch all rows from table
        Query q2 = session2.createQuery("from EmployeeWithAnnotation");
        q2.setFirstResult(2);
        q2.setMaxResults(4);
        List<EmployeeWithAnnotation> emplist = q2.list();
        
        Iterator<EmployeeWithAnnotation> empitr = emplist.iterator();
        
        while(empitr.hasNext()) {
            System.out.println(empitr.next());
        }
        
        //update a row in the table
        //delete a row
        Transaction tx= session2.beginTransaction();
        //Query q3 = session2.createQuery("update EmployeeWithAnnotation set firstName=:f,lastName=:l where firstName=:cf");
        //q3.setParameter("f", "Charan Thej");
        //q3.setParameter("l", "Aware");
        //q3.setParameter("cf", "Lilly");
        Query q3 = session2.createQuery("delete from EmployeeWithAnnotation where id=:ci");
        q3.setParameter("ci", 110);
        q3.executeUpdate();
        tx.commit();
        
        //fetch all rows from table
        Query q4 = session2.createQuery("from EmployeeWithAnnotation");
        List<EmployeeWithAnnotation> upemplist = q4.list();
        
        Iterator<EmployeeWithAnnotation> upempitr = upemplist.iterator();
        
        while(upempitr.hasNext()) {
            System.out.println(upempitr.next());
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //session2.close();System.out.println();
        
        //USING THE criteria CLASS - HCQL
        
        Criteria c = session2.createCriteria(EmployeeWithAnnotation.class);
        c.setFirstResult(0);  
        c.setMaxResults(20);
        c.addOrder(Order.asc("firstName")); 
        c.add(Restrictions.eq("lastName", "Bharot"));
        //c.setProjection(Projections.property("id"));
        //c.setProjection(Projections.property("firstName"));
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("id"));
        p.add(Projections.property("firstName"));
        c.setProjection(p);
        
        List lnamecrlist = c.list();
        Iterator lnamecritr = lnamecrlist.iterator();
        //paremp a = new paremp();
        while(lnamecritr.hasNext()) {
            Object[] ob = (Object[]) lnamecritr.next();
            //a = (paremp) lnamecritr.next();
            //EmployeeWithAnnotation a = lnamecritr.next();
            //EmployeeWithAnnotation a = lnamecritr.next();
            System.out.println(ob[0] + "  --  " + ob[1]);
        }
        System.out.println("fgfgf saved in DB");
    }
}

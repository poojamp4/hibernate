package p;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
 
import org.hibernate.cfg.Configuration;
  
public class Storedata {  
  
    public static void main( String[] args )  
    {  
         
          
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();  
        Session session = factory.openSession(); 
        // Session session = factory.getCurrentSession();  
        Transaction t = session.beginTransaction(); 
          Employee e1=new Employee();  
       
          
         
            e1.setId(3);    
            e1.setFirstName("mohan");    
            e1.setLastName("hadadi");
            
          
            
            
         
       session.save(e1); 
       
     /*  Query query = session.createQuery("from Employee where id= :id");
       query.setLong("id", 7);
       Employee emp = (Employee) query.uniqueResult();
       System.out.println("Employee Name="+emp.getFirstName());
       Query query =session.createQuery("select e1.firstName from Employee e1");
       List l=query.list();
       Iterator itr=l.iterator();
       while(itr.hasNext())
       {
    	   String s=(String)itr.next();
    	   System.out.println("Empolyee names:"+s);
       }*/

       t.commit();  
       System.out.println("successfully saved");  
       System.out.println();
       // factory.close();  
       // session.close();     
    }  
}  
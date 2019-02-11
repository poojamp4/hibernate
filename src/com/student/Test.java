package com.student;

import java.util.Iterator;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Student st=new Student();
		Student s1=new Student();
		Student s2=new Student();
		st.setRollno(1);
		st.setName("pooja");
		st.setMarks(85);
		 
		s1.setRollno(2);
		s1.setName("ravi");
		s1.setMarks(99);
		 
		s2.setRollno(3);
		s2.setName("nithi");
		s2.setMarks(90);
		
		s.save(st);
		s.save(s1);
		s.save(s2);
		t.commit();
		SessionFactory sf1=cfg.buildSessionFactory();
		Session session=sf1.openSession();
		Query query=session.createQuery("select ss.name from Student ss");
		java.util.List list=query.list();
		Iterator itr=list.iterator();
		 while(itr.hasNext())
		 {
			 String sr=(String)itr.next();
			 System.out.println("student name:"+sr);
		 }
		
		System.out.println("entered");
		sf.close();
		sf1.close();
		s.close();
		session.close();
;
	}

}

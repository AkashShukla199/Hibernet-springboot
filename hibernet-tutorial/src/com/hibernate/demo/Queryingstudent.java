package com.hibernate.demo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;

public class Queryingstudent {
		public static void main(String args[]) {
			//create session factory
			SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
			//create a session
			Session session=factory.getCurrentSession();
			try
			{
				session.beginTransaction();
				//save
				//query
				List<Student> thestudents=session.createQuery("from Student").list();				//commit
				for(Student tempstudent: thestudents) {
					System.out.println(tempstudent);
					}
				System.out.println("Done!"); 
			}
			finally {
				factory.close();
			}
		}
}
 
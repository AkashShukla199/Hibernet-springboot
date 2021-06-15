package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
				System.out.println("Creating a new student object");
				
				//use the session object
				
				//student object
				Student tempstudent=new Student("Akash","Shukla","akashshuklakld@gmail.com");
				//start
				session.beginTransaction();
				//save
				System.out.println("Saving the student.........");
				session.save(tempstudent);
				
				//commit
				session.getTransaction().commit();
				System.out.println("Done!"); 
			}
			finally {
				factory.close();
			}
		}
}
 
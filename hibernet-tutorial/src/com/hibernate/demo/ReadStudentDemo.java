package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
				Student tempstudent=new Student("vikas","Shukla","vpnshuklakld@gmail.com");
				//start
				session.beginTransaction();
				//save
				System.out.println("Saving the student.........");
				System.out.println(tempstudent);
				session.save(tempstudent);
				
				//commit
				session.getTransaction().commit();
				//new code
				//find out what primary key
				System.out.println("Saved student"+tempstudent.getId());
				//now get a new session and start  a transaction 
				session=factory.getCurrentSession();
				session.beginTransaction();
				System.out.println("gettin student with id "+tempstudent.getId());
				
				Student mystudent=session.get(Student.class, tempstudent.getId());
				System.out.println("Get complete:"+mystudent);
				session.getTransaction().commit();
				System.out.println("Done!"); 
			}
			finally {
				factory.close();
				
			}
		}
}
 
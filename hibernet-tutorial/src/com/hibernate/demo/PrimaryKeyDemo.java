package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//create a session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating a new student object");

//use the session object

//student object
			Student tempstudent1 = new Student("Akash", "Shukla", "akashshuklakld@gmail.com");
//start

			Student tempstudent2 = new Student("Aman", "Shukla", "akashshuklakld@gmail.com");

			Student tempstudent3 = new Student("vikash", "pandey", "akashshuklakld@gmail.com");
			
			session.beginTransaction();
//save
			System.out.println("Saving the student.........");
			session.save(tempstudent1);
			session.save(tempstudent2);
			session.save(tempstudent3);
//commit
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}

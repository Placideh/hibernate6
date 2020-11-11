package com.placideh.hibernate6;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student student=new Student();
    	student.setRollno(21172);
    	student.setName("Placideh");
    	student.setMarks(13);
    	
    	Student student2=new Student();
    	student2.setRollno(21140);
    	student2.setName("Yannick");
    	student2.setMarks(13);
//    	HERE IT IS MANY TO MANY RELATIONSHIP WE ARE GIVING MANY STUDENTS MANY LAPTOPS.
    	//laptop1 ..Dell
    	Laptop laptop=new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	// Here also a LAPTOP has to know the students
    	laptop.getStud().add(student);
    	//laptop2 ...HP
    	Laptop lap=new Laptop();
    	lap.setLid(102);
    	lap.setLname("Hp");
    	lap.getStud().add(student);
    	// addLaptop 2 student
    	student.getLaptop().add(laptop);
    	student.getLaptop().add(lap);
    	student2.getLaptop().add(laptop);
    	Configuration config =new Configuration().configure()
						.addAnnotatedClass(Student.class)
						.addAnnotatedClass(Laptop.class);
    	
    	SessionFactory sf=config.buildSessionFactory();
    	Session session=sf.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.save(student2);
    	session.save(laptop);
    	session.save(lap);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}

package main;

import main.com.myApp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteFromDatabase {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate-config.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        int id=1;
        Student student=session.get(Student.class,id);
        System.out.println(student);

//        delete object from db
        session.delete(student);
        session.getTransaction().commit();


    }
}

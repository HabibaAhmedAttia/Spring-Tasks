package main;

import main.com.myApp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorAndCourse {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //define session
        Session session = sessionFactory.getCurrentSession();

        try {

            Student student=new Student("ahmed","salah");

            //1.open the transaction
            session.beginTransaction();


            //2.save the object
            session.save(student);

            //3.commit the changes
            session.getTransaction().commit();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }
    }
}


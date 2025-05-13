package main;

import main.com.myApp.model.Student;
import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.jws.soap.SOAPBinding;

public class CreateIntoDatabase {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
            //1.open the transaction
            session.beginTransaction();

            User user=new User("habiba","1234");


            //2.save the object
            session.persist(user);

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


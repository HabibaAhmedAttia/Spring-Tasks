package main;

import main.com.myApp.model.Student;
import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class QueriesOnDatabaseHQL {
    public static void main(String[] args) {
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
//            HQL get records query
            Query query=session.createQuery("from User");
            List<User> allUsers=query.getResultList();
            for (User user:allUsers)
            {
                System.out.println(user);
            }

//            HQL Update Query
//            Query query=session.createQuery("Update User Set username=:u, password=:p where id=:i");
//            query.setParameter("u","Ali");
//            query.setParameter("p","1289");
//            query.setParameter("i",1);
//            query.executeUpdate();

//            HQL Get Records With Pagination
            /*Query query=session.createQuery("from User");
            query.setFirstResult(5);
            query.setMaxResults(10);
            List<User> allUsers=query.getResultList();
            for (User user:allUsers)
            {
                System.out.println(user);
            }*/
//            HQL Aggregation Functions
//            Query query=session.createQuery("select sum(salary) from User");
//            List<Double> list=query.getResultList();
//            System.out.println(list.get(0));




            session.getTransaction().commit();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}

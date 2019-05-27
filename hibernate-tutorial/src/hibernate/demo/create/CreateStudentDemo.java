package hibernate.demo.create;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Andrew", "Sotirov", "andsot@abv.bg");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}

package hibernate.demo.query;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").list();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s WHERE s.lastName='djorev'").list();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s WHERE s.lastName='djorev' or s.firstName='Daffy'").list();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email like 'djorev%'").list();

            displayStudents(theStudents);

            session.getTransaction().commit();
        } finally {
            factory.getCurrentSession().close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student s : theStudents) {
            System.out.println(s);
        }
    }
}

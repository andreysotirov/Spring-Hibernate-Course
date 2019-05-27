package hibernate.demo.delete;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 3007;
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);

//            session.delete(student);
            session.createQuery("delete from Student where id=3006").executeUpdate();

            session.getTransaction().commit();

        } finally {

        }
    }

}

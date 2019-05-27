package hibernate.demo.update;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 3000;
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            student.setFirstName("Scoobsy");

            System.out.println("Update email");
            session.createQuery("update Student set email='fooss@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        }finally {
            factory.getCurrentSession().close();
        }

    }
}

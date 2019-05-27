package hibernate.demo.read;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Duck", "duck@abv.bg");

            session.beginTransaction();
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Generated ID: " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student student1 = session.get(Student.class, student.getId());

            System.out.println("Student" + student1);

        } finally {
            factory.getCurrentSession().close();
        }
    }
}

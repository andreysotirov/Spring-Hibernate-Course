package hibernate.demo.create;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int id = 1;
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("Guitar");
            Course course2 = new Course("Java");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

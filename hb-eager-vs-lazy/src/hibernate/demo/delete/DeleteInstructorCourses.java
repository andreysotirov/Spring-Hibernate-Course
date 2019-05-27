package hibernate.demo.delete;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCourses {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id = 10;
            session.beginTransaction();

            Course course = session.get(Course.class, id);

            System.out.println("Course " + course);
            session.delete(course);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

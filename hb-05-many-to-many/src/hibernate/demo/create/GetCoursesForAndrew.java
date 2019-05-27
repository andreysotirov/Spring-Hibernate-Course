package hibernate.demo.create;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForAndrew {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            Student student = session.get(Student.class, id);

            System.out.println("Loaded student " + student);
            System.out.println("Student courses" + student.getCourses());


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

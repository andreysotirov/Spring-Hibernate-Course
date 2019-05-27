package hibernate.demo.get;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazy {

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

            System.out.println("andrewSotirov: Instructor: " + instructor);
            System.out.println("andrewSotirov: Instructor courses:" + instructor.getCourses());
            System.out.println("andrewSotirov: Instructor courses:" + instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("\nSession is closed\n");
            System.out.println("andrewSotirov: Instructor courses:" + instructor.getCourses());

        } finally {
            session.close();
            factory.close();
        }
    }
}

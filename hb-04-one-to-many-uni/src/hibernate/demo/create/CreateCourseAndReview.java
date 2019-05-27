package hibernate.demo.create;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReview {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course1 = new Course("JAVA advanced");

            course1.addReview(new Review("Best course"));
            course1.addReview(new Review("Great"));
            course1.addReview(new Review("Amazing"));

            System.out.println("Saving the course");
            System.out.println(course1);
            System.out.println(course1.getReviews());

            session.save(course1);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

package hibernate.demo.get;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCreateCourseAndReview {

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

            int id = 10;

            session.beginTransaction();

            Course course = session.get(Course.class, id);

            System.out.println(course);

            System.out.println(course.getReviews());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

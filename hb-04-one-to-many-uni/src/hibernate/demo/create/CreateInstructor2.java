package hibernate.demo.create;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Andrew", "Sotirov", "ravingbg@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/evilshu", "playing PC Games");

            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();

            System.out.println("Saving instructor: " + instructor);

            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

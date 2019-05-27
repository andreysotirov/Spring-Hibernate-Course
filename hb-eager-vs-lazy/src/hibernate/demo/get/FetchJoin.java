package hibernate.demo.get;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin {

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

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                                                            "join fetch i.courses " +
                                                            "where i.id = :instructorId",
                                                             Instructor.class);

            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("andrewSotirov: Instructor: " + instructor);
            System.out.println("andrewSotirov: Instructor courses:" + instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("Session closed");
            System.out.println("andrewSotirov: Instructor courses:" + instructor.getCourses());


        } finally {
            session.close();
            factory.close();
        }
    }
}

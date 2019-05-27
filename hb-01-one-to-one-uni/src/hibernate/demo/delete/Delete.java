package hibernate.demo.delete;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id = 3;
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, id);

            if (instructor != null){
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }

            session.getTransaction().commit();
        }finally {
            factory.getCurrentSession().close();
        }
    }
}

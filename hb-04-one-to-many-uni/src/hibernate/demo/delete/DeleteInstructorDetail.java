package hibernate.demo.delete;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Insturctor Detail " + instructorDetail);

            System.out.println("Instructor " + instructorDetail.getInstructor());

            instructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting");
            session.delete(instructorDetail);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

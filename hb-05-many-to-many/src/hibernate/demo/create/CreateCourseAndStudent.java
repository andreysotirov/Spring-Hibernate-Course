package hibernate.demo.create;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudent {

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

            Course course1 = new Course("JAVA advanced");
            session.save(course1);

            Student student1 = new Student("andrew", "Sotirov", "ravin@abv.bg");
            Student student2 = new Student("svetlana", "Sotirova", "svetla@abv.bg");

            course1.addStudent(student1);
            course1.addStudent(student2);

            System.out.println("\nSaving students...");

            session.save(student1);
            session.save(student2);
            System.out.println("Saved student " + course1.getStudents());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

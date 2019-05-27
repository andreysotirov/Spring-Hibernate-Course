package hibernate.demo.primery_key;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimeryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student1 = new Student("kazan", "georgiev", "abv@abv.bg");
            Student student2 = new Student("georgi", "velikov", "velikov@abv.bg");
            Student student3 = new Student("velin", "djorev", "djorev@abv.bg");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done");

        }finally {
            factory.getCurrentSession().close();
        }
    }
}

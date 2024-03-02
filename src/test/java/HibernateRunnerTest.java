import entity.User;
import org.junit.jupiter.api.Test;
import util.hibernate.HibernateUtil;

public class HibernateRunnerTest {
    @Test
    void checkH2() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var user = User.builder()
                    .name("TestH2")
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }
    }
}
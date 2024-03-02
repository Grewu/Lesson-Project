import entity.User;
import org.junit.jupiter.api.Test;
import util.hibernate.HibernateUtil;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateRunnerTest {
    @Test
    void checkH2() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.createQuery("select u from User u");

            session.getTransaction().commit();
        }
    }

    @Test
    void checkHQL() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
        }
    }

    @Test
    void checkCriteriaApi() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var cd = session.getCriteriaBuilder();

            var criteria = cd.createQuery(User.class);
            var user = criteria.from(User.class);

            criteria.select(user);

            session.createQuery(criteria).list();


            session.getTransaction().commit();
        }
    }

}

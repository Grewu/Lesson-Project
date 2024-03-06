import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import util.hibernate.HibernateUtil;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

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

    @Test
    @Transactional
    void checkTransaction() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.find(User.class, 1L, LockModeType.OPTIMISTIC_FORCE_INCREMENT);


            session.getTransaction().commit();
        }
    }

}

package dao.impl;

import dao.api.AccountDao;
import entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account findById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Account account = session.get(Account.class, id);

            session.getTransaction().commit();

            return account;
        }
    }

    @Override
    public List<Account> findAll() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Account> accounts = session.createQuery("SELECT a FROM Account a", Account.class).list();

            session.getTransaction().commit();
            return accounts;
        }
    }

    @Override
    public Long save(Account account) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(account);

            session.getTransaction().commit();

            return account.getId();
        }
    }

    @Override
    public void update(Account account) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.update(account);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.delete(id);

            session.getTransaction().commit();
        }
    }

}

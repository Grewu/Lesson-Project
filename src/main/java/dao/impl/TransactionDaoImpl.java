package dao.impl;

import dao.api.TransactionDao;
import entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public Transaction findById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Transaction account = session.get(Transaction.class, id);

            session.getTransaction().commit();

            return account;
        }
    }

    @Override
    public List<Transaction> findAll() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Transaction> transactions = session.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList();

            session.getTransaction().commit();
            return transactions;
        }
    }

    @Override
    public Long save(Transaction transaction) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(transaction);

            session.getTransaction().commit();

            return transaction.getId();
        }
    }

    @Override
    public void update(Transaction transaction) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.update(transaction);

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

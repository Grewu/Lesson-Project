package dao.impl;

import dao.api.TransactionDao;
import entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public Optional<Transaction> findById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Transaction account = session.get(Transaction.class, id);

            session.getTransaction().commit();

            return Optional.ofNullable(account);
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
    public Transaction save(Transaction transaction) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(transaction);

            session.getTransaction().commit();

            return transaction;
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

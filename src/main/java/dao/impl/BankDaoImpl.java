package dao.impl;

import dao.api.BankDao;
import entity.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class BankDaoImpl implements BankDao {
    @Override
    public Optional<Bank> findById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Bank bank = session.get(Bank.class, id);

            session.getTransaction().commit();

            return Optional.ofNullable(bank);
        }
    }

    @Override
    public List<Bank> findAll() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Bank> banks = session.createQuery("SELECT b FROM Bank b", Bank.class).list();

            session.getTransaction().commit();
            return banks;
        }
    }

    @Override
    public Bank save(Bank bank) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(bank);

            session.getTransaction().commit();

            return bank;
        }
    }

    @Override
    public void update(Bank bank) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.update(bank);

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

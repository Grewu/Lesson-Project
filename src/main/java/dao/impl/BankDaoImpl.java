package dao.impl;

import dao.BankDao;
import entity.Account;
import entity.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.hibernate.HibernateUtil;

import java.util.List;

public class BankDaoImpl implements BankDao {
    @Override
    public Bank findById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Bank bank = session.get(Bank.class, id);

            session.getTransaction().commit();

            return bank;
        }
    }

    @Override
    public List<Bank> findAll() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Bank> banks = session.createQuery("FROM Bank", Bank.class).getResultList();

            session.getTransaction().commit();
            return banks;
        }
    }

    @Override
    public Long save(Bank bank) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(bank);

            session.getTransaction().commit();

            return bank.getId();
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

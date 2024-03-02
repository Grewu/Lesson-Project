package dao.impl;

import dao.AccountDao;
import data.AccountDto;
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
        return null;
    }

    @Override
    public Long save(Account product) {
        return null;
    }

    @Override
    public void update(AccountDto accountDto) {

    }

    @Override
    public void delete(Long id) {

    }

}

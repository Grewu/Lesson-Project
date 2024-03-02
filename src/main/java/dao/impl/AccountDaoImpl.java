package dao.impl;

import dao.AccountDao;
import data.AccountDto;
import entity.Account;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account findById(Long id) {
        return null;
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

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = User.builder()
                    .id(4L)
                    .name("Test")
                    .cash(BigDecimal.valueOf(10))
                    .build();

            session.save(user);

            session.getTransaction().commit();
        }
    }
}

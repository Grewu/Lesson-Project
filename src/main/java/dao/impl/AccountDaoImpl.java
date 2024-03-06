package dao.impl;

import dao.api.DaoBase;
import entity.Account;
import org.hibernate.SessionFactory;


public class AccountDaoImpl extends DaoBase<Long, Account> {


    public AccountDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory,Account.class);
    }
}

package dao.impl;

import dao.RepositoryBase;
import data.AccountDto;
import entity.Account;
import mapper.DtoEntityMapper;
import org.hibernate.SessionFactory;


public class AccountDaoImpl extends RepositoryBase<Long, Account, AccountDto> {

    public AccountDaoImpl(SessionFactory sessionFactory, DtoEntityMapper<Account, AccountDto> mapper) {
        super(sessionFactory, Account.class, AccountDto.class, mapper);
    }
}

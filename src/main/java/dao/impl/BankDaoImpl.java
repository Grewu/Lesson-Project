package dao.impl;

import dao.RepositoryBase;
import data.AccountDto;
import data.BankDto;
import entity.Account;
import entity.Bank;
import mapper.DtoEntityMapper;
import org.hibernate.SessionFactory;

public class BankDaoImpl extends RepositoryBase<Long, Bank, BankDto> {
    public BankDaoImpl(SessionFactory sessionFactory, DtoEntityMapper<Bank, BankDto> mapper) {
        super(sessionFactory, Bank.class, BankDto.class, mapper);
    }

}

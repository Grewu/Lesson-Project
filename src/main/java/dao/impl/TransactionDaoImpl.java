package dao.impl;

import dao.RepositoryBase;
import data.AccountDto;
import data.TransactionDto;
import entity.Account;
import entity.Transaction;
import mapper.DtoEntityMapper;
import mapper.TransactionMapper;
import org.hibernate.SessionFactory;

public class TransactionDaoImpl extends RepositoryBase<Long, Transaction, TransactionDto> {
    public TransactionDaoImpl(SessionFactory sessionFactory, DtoEntityMapper<Transaction, TransactionDto> mapper) {
        super(sessionFactory, Transaction.class, TransactionDto.class, mapper);
    }
}

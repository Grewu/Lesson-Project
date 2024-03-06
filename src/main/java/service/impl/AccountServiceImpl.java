package service.impl;

import dao.api.AccountDao;
import dao.api.DaoBase;
import data.AccountDto;
import entity.Account;
import mapper.AccountMapper;
import service.api.AccountService;

import java.util.List;
import java.util.Optional;


public class AccountServiceImpl implements AccountService {
    private final AccountMapper mapper;
    private final DaoBase<Long,Account> accountDao;

    public AccountServiceImpl(AccountMapper mapper, DaoBase<Long, Account> accountDao) {
        this.mapper = mapper;
        this.accountDao = accountDao;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account create(AccountDto accountDto) {
        Account account = mapper.toAccount(accountDto);
        accountDao.save(account);
        return account;
    }

    @Override
    public void update(AccountDto accountDto) {
        Account account = mapper.toAccount(accountDto);
        accountDao.update(account);
    }

    @Override
    public void delete(Long id) {
        accountDao.delete(id);
    }

}

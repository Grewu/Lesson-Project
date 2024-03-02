package service.impl;

import dao.api.AccountDao;
import data.AccountDto;
import entity.Account;
import mapper.AccountMapper;
import service.api.AccountService;

import java.util.List;
import java.util.Optional;


public class AccountServiceImpl implements AccountService {
    private final AccountMapper mapper;
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountMapper mapper, AccountDao accountDao) {
        this.mapper = mapper;
        this.accountDao = accountDao;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accountDao.findById(id));
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Long create(AccountDto accountDto) {
        Account account = mapper.toAccount(accountDto);
        return accountDao.save(account);
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

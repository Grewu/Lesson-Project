package dao;

import data.AccountDto;
import entity.Account;

import java.util.List;

public interface AccountDao {

    Account findById(Long id);

    List<Account> findAll();


    Long save(Account product);

    void update(AccountDto accountDto);


    void delete(Long id);
}
package service.api;

import data.AccountDto;
import entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(Long id);

    List<Account> findAll();

    Long create(AccountDto accountDto);

    void update(AccountDto accountDto);

    void delete(Long id);
}

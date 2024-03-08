package service.impl;

import dao.RepositoryBase;
import data.AccountDto;
import entity.Account;
import lombok.RequiredArgsConstructor;
import mapper.AccountMapper;
import mapper.DtoEntityMapper;
import service.ServiceBase;
import service.api.AccountService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



public class AccountServiceImpl extends ServiceBase<Account,Long,AccountDto> implements AccountService {

    public AccountServiceImpl(DtoEntityMapper<Account, AccountDto> mapper, RepositoryBase<Long, Account,AccountDto> repositoryBase) {
        super(mapper, repositoryBase);
    }
}

package service.impl;

import dao.RepositoryBase;
import data.BankDto;
import entity.Bank;
import mapper.DtoEntityMapper;
import service.ServiceBase;
import service.api.BankService;


public class BankServiceImpl extends ServiceBase<Bank, Long, BankDto> implements BankService {
    public BankServiceImpl(DtoEntityMapper<Bank, BankDto> mapper, RepositoryBase<Long, Bank,BankDto> repositoryBase) {
        super(mapper, repositoryBase);
    }

}

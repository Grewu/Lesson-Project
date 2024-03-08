package service.impl;

import dao.RepositoryBase;
import data.TransactionDto;
import entity.Transaction;
import mapper.DtoEntityMapper;
import service.ServiceBase;
import service.api.TransactionService;


public class TransactionServiceImpl extends ServiceBase<Transaction, Long, TransactionDto> implements TransactionService {
    public TransactionServiceImpl(DtoEntityMapper<Transaction, TransactionDto> mapper, RepositoryBase<Long, Transaction,TransactionDto> repositoryBase) {
        super(mapper, repositoryBase);
    }

}

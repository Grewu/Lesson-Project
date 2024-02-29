package service.impl;

import dao.TransactionDao;
import data.TransactionDto;
import entity.Transaction;
import mapper.TransactionMapper;
import service.api.TransactionService;

import java.util.List;
import java.util.Optional;


public class TransactionServiceImpl implements TransactionService {
    private final TransactionMapper mapper;
    private final TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionMapper mapper, TransactionDao transactionDao) {
        this.mapper = mapper;
        this.transactionDao = transactionDao;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return Optional.ofNullable(transactionDao.findById(id));
    }

    @Override
    public List<Transaction> findAll(TransactionDto transactionDto) {
        return transactionDao.findAll();
    }

    @Override
    public Long create(TransactionDto transactionDto) {
        Transaction transaction = mapper.toTransaction(transactionDto);
        return transactionDao.save(transaction);
    }

    @Override
    public void update(TransactionDto transactionDto) {
        transactionDao.update(transactionDto);
    }

    @Override
    public void delete(Long id ) {
        transactionDao.delete(id);
    }
}

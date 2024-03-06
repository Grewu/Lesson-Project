package service.api;

import data.TransactionDto;
import entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> findById(Long id);

    List<Transaction> findAll(TransactionDto transactionDto);

    Transaction create(TransactionDto transactionDto);

    void update(TransactionDto transactionDto);

    void delete(Long id);
}

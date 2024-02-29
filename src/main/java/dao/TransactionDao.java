package dao;

import data.TransactionDto;
import entity.Transaction;

import java.util.List;

public interface TransactionDao {
    Transaction findById(Long id);

    List<Transaction> findAll();

    Long save(Transaction product);

    void update(TransactionDto accountDto);


    void delete(Long id);
}

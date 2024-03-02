package dao;

import data.TransactionDto;
import entity.Transaction;

import java.util.List;

public interface TransactionDao {
    Transaction findById(Long id);

    List<Transaction> findAll();

    Long save(Transaction product);

    void update(Transaction transaction);


    void delete(Long id);
}

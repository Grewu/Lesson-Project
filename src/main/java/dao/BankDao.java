package dao;

import data.BankDto;
import entity.Bank;

import java.util.List;

public interface BankDao {
    Bank findById(Long id);

    List<Bank> findAll();

    Long save(Bank bank);

    void update(BankDto bankDto);


    void delete(Long id);
}

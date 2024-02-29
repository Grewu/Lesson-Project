package service.api;

import data.BankDto;
import entity.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {
    Optional<Bank> findById(Long id);

    List<Bank> findAll(BankDto bankDto);

    Long create(BankDto bankDto);

    void update(BankDto bankDto);

    void delete(Long id);
}

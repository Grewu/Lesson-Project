package service.impl;

import dao.api.BankDao;
import data.BankDto;
import entity.Bank;
import mapper.BankMapper;
import service.api.BankService;

import java.util.List;
import java.util.Optional;


public class BankServiceImpl implements BankService {

    private final BankMapper mapper;
    private final BankDao bankDao;

    public BankServiceImpl(BankMapper mapper, BankDao bankDao) {
        this.mapper = mapper;
        this.bankDao = bankDao;
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return Optional.ofNullable(bankDao.findById(id));
    }

    @Override
    public List<Bank> findAll(BankDto bankDto) {
        return bankDao.findAll();
    }

    @Override
    public Long create(BankDto bankDto) {
        Bank bank = mapper.toBank(bankDto);
        return bankDao.save(bank);
    }

    @Override
    public void update(BankDto bankDto) {
        Bank bank = mapper.toBank(bankDto);
        bankDao.update(bank);
    }

    @Override
    public void delete(Long id) {
        bankDao.delete(id);
    }
}

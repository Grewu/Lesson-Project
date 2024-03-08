package dao.api;

import data.BankDto;
import entity.Bank;

public interface BankDao extends Repository<Long, Bank, BankDto> {
}

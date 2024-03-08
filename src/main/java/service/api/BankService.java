package service.api;

import data.BankDto;
import entity.Bank;
import service.CRUDService;

public interface BankService extends CRUDService<Bank, Long, BankDto> {

}

package service.api;

import data.TransactionDto;
import entity.Transaction;
import service.CRUDService;

public interface TransactionService extends CRUDService<Transaction, Long, TransactionDto> {

}

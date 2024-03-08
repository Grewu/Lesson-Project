package dao.api;

import data.TransactionDto;
import entity.Transaction;

public interface TransactionDao extends Repository<Long, Transaction, TransactionDto> {

}

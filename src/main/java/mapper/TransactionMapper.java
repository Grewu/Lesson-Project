package mapper;

import data.TransactionDto;
import entity.Transaction;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper extends DtoEntityMapper<Transaction, TransactionDto> {


}

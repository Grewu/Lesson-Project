package mapper;

import data.TransactionDto;
import entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = Transaction.class)
public interface TransactionMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    Transaction toTransaction(TransactionDto transactionDto);

    Transaction toDto(TransactionDto transactionDto);
}

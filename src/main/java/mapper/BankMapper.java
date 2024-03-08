package mapper;

import data.BankDto;
import entity.Bank;
import org.mapstruct.Mapper;

@Mapper
public interface BankMapper extends DtoEntityMapper<Bank, BankDto> {

}

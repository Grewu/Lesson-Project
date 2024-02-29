package mapper;

import data.BankDto;
import entity.Bank;
import org.mapstruct.Mapper;

@Mapper
public interface BankMapper {
    Bank toBank(BankDto bankDto);

    BankDto toDto(Bank bank);
}

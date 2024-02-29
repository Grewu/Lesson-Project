package mapper;

import data.BankDto;
import entity.Bank;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T17:52:30+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class BankMapperImpl implements BankMapper {

    @Override
    public Bank toBank(BankDto bankDto) {
        if ( bankDto == null ) {
            return null;
        }

        Bank bank = new Bank();

        return bank;
    }

    @Override
    public BankDto toDto(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        Long id = null;
        Long userId = null;
        String bankName = null;

        BankDto bankDto = new BankDto( id, userId, bankName );

        return bankDto;
    }
}

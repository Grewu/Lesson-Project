package mapper;

import data.AccountDto;
import entity.Account;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T17:52:30+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        return account;
    }

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        Long accountId = null;
        Long userId = null;
        Long bankId = null;
        String nameUser = null;
        String bankName = null;
        Long idUser = null;
        BigDecimal balance = null;
        String accountNumber = null;

        AccountDto accountDto = new AccountDto( accountId, userId, bankId, nameUser, bankName, idUser, balance, accountNumber );

        return accountDto;
    }
}

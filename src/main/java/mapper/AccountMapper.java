package mapper;

import data.AccountDto;
import entity.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    Account toAccount(AccountDto accountDto);

    AccountDto toDto(Account account);
}

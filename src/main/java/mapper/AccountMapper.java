package mapper;

import data.AccountDto;
import entity.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper extends DtoEntityMapper<Account, AccountDto> {

}

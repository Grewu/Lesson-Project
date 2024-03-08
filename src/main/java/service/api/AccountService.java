package service.api;

import data.AccountDto;
import entity.Account;
import service.CRUDService;


public interface AccountService extends CRUDService<Account, Long, AccountDto> {

}

package service.api;

import data.UserDto;
import entity.User;
import service.CRUDService;

public interface UserService extends CRUDService<User, Long, UserDto> {

}

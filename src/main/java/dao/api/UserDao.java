package dao.api;

import data.UserDto;
import entity.User;

public interface UserDao extends Repository<Long, User, UserDto> {
}

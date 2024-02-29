package service.api;

import data.UserDto;
import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);

    List<User> findAll(UserDto userDto);

    Long create(UserDto userDto);

    void update(UserDto userDto);

    void delete(Long id);
}

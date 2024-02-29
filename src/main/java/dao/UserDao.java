package dao;

import data.UserDto;
import entity.User;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    List<User> findAll();

    Long save(User user);

    void update(UserDto userDto);


    void delete(Long id);
}

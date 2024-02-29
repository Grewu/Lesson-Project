package service.impl;

import dao.UserDao;
import data.UserDto;
import entity.User;
import mapper.UserMapper;
import service.api.UserService;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserDao userDao;

    public UserServiceImpl(UserMapper mapper, UserDao userDao) {
        this.mapper = mapper;
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userDao.findById(id));
    }

    @Override
    public List<User> findAll(UserDto user) {
        return userDao.findAll();
    }

    @Override
    public Long create(UserDto userDto) {
        User user = mapper.toUser(userDto);
        return userDao.save(user);
    }

    @Override
    public void update(UserDto userDto) {
        userDao.update(userDto);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}

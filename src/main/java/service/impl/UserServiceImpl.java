package service.impl;

import dao.RepositoryBase;
import data.UserDto;
import entity.User;
import mapper.DtoEntityMapper;
import service.ServiceBase;
import service.api.UserService;


public class UserServiceImpl extends ServiceBase<User, Long, UserDto> implements UserService {
    public UserServiceImpl(DtoEntityMapper<User, UserDto> mapper, RepositoryBase<Long, User, UserDto> repositoryBase) {
        super(mapper, repositoryBase);
    }
}

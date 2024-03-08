package dao.impl;

import dao.RepositoryBase;
import data.UserDto;
import entity.User;
import mapper.DtoEntityMapper;
import org.hibernate.SessionFactory;

public class UserDaoImpl extends RepositoryBase<Long, User, UserDto> {
    public UserDaoImpl(SessionFactory sessionFactory, DtoEntityMapper<User, UserDto> mapper) {
        super(sessionFactory, User.class, UserDto.class, mapper);
    }
}


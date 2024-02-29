package mapper;


import data.UserDto;
import entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper{
    User toUser(UserDto userDto);
    UserDto toDto(User user);
}

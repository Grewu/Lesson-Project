package mapper;


import data.UserDto;
import entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends DtoEntityMapper<User, UserDto> {

}

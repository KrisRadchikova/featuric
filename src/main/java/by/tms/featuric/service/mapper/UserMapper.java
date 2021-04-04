package by.tms.featuric.service.mapper;

import by.tms.featuric.dto.UserDto;
import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.service.interfaces.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<FtrcUser, UserDto> {
    @Override
    public UserDto toDto(FtrcUser entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setImage(entity.getImage());
        userDto.setLogin(entity.getLogin());
        userDto.setPassword(entity.getPassword());
        userDto.setEmail(entity.getEmail());
        userDto.setUserStatus(entity.getUserStatus());
        return userDto;
    }

    @Override
    public FtrcUser toEntity(UserDto dto) {
        FtrcUser user = new FtrcUser();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setImage(dto.getImage());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setUserStatus(dto.getUserStatus());
        return user;
    }

    @Override
    public UserDto toShortDto(FtrcUser entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setLogin(entity.getLogin());
        userDto.setPassword(entity.getPassword());
        userDto.setEmail(entity.getEmail());
        userDto.setUserStatus(entity.getUserStatus());
        return userDto;
    }
}

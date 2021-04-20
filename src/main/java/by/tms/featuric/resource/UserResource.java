package by.tms.featuric.resource;

import by.tms.featuric.dto.UserDto;
import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.service.interfaces.UserService;
import by.tms.featuric.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/user")
//TODO create getAll, findByFirstNameAndLastName, findByLogin
public class UserResource {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserResource(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable BigInteger id){
        return userMapper.toDto(userService.findUserById(id));
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto){
        FtrcUser user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.save(user));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable BigInteger id, @RequestBody UserDto userDto){
        FtrcUser user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

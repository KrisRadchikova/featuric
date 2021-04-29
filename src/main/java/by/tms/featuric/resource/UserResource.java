package by.tms.featuric.resource;

import by.tms.featuric.dto.UserDto;
import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.service.interfaces.UserService;
import by.tms.featuric.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserResource(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/byLogin/{login}")
    public UserDto getByLogin(@PathVariable String login){
        return userMapper.toDto(userService.findUserByLogin(login));
    }

    @GetMapping("/byNames/{first}/{last}")
    public UserDto getByFirstNameAndLastName(@PathVariable String first, @PathVariable String last){
        return userMapper.toDto(userService.findUserByFirstNameAndLastName(first, last));
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

    @GetMapping("/getAll")
    public List<UserDto> getAll(){
        return userService.getAllUsers().stream()
                .map(userMapper::toShortDto)
                .collect(Collectors.toList());
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

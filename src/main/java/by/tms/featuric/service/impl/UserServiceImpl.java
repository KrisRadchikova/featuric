package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.exception.ExistsException;
import by.tms.featuric.exception.IndexOutOfBoundsException;
import by.tms.featuric.exception.NotFoundException;
import by.tms.featuric.repository.FtrcUserRepository;
import by.tms.featuric.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private FtrcUserRepository ftrcUserRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(FtrcUserRepository ftrcUserRepository, PasswordEncoder passwordEncoder) {
        this.ftrcUserRepository = ftrcUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public FtrcUser save(FtrcUser ftrcUser) {
        log.info("Method - save user");
        if (ftrcUserRepository.findFtrcUserByLogin(ftrcUser.getLogin()) != null) {
            throw new ExistsException("User exists");
        }
        ftrcUser.setPassword(passwordEncoder.encode(ftrcUser.getPassword()));
        return ftrcUserRepository.save(ftrcUser);
    }

    @Override
    public FtrcUser update(BigInteger id, FtrcUser ftrcUserRequest) {
        log.info("Method - update user");
        ftrcUserRepository.findById(id).map(ftrcUser -> {
            ftrcUser.setFirstName(ftrcUserRequest.getFirstName());
            ftrcUser.setLastName(ftrcUserRequest.getLastName());
            ftrcUser.setImage(ftrcUserRequest.getImage());
            ftrcUser.setLogin(ftrcUserRequest.getLogin());
            ftrcUser.setPassword(ftrcUserRequest.getPassword());
            ftrcUser.setUserStatus(ftrcUserRequest.getUserStatus());
            ftrcUser.setEmail(ftrcUserRequest.getEmail());
            ftrcUser.setRating(ftrcUserRequest.getRating());
            return ftrcUserRepository.save(ftrcUser);
        });
        return ftrcUserRequest;
    }

    @Override
    public void deleteById(BigInteger id) {
        log.info("Method - delete user by ID");
        if (ftrcUserRepository.findById(id).isPresent()) {
            ftrcUserRepository.deleteById(id);
        }
        throw new NotFoundException("User with id " + id + " not found");
    }

    @Override
    public List<FtrcUser> getAllUsers() {
        log.info("Method - get all users");
        return ftrcUserRepository.findAll();
    }

    @Override
    public FtrcUser findUserById(BigInteger id) {
        log.info("Method - find user by ID");
        return ftrcUserRepository.findById(id).orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public FtrcUser findUserByFirstNameAndLastName(String firstName, String lastName) {
        log.info("Method - find user by first name and last name");
        return ftrcUserRepository.findFtrcUserByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public FtrcUser findUserByLogin(String login) {
        log.info("Method - find user by login");
        FtrcUser user = ftrcUserRepository.findFtrcUserByLogin(login);
        if (user == null) {
            throw new NotFoundException("User with login " + login + " not found");
        }
        return user;
    }

    //UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String login) throws NotFoundException {
        log.info("Method - load user by login(username)//security");
        FtrcUser user = ftrcUserRepository.findFtrcUserByLogin(login);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return (UserDetails) user;
    }
}

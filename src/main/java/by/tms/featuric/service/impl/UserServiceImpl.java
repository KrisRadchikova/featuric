package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.repository.FtrcUserRepository;
import by.tms.featuric.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

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
        ftrcUser.setPassword(passwordEncoder.encode(ftrcUser.getPassword()));
        return ftrcUserRepository.save(ftrcUser);
    }

    @Override
    public FtrcUser update(BigInteger id, FtrcUser ftrcUserRequest) {
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
        ftrcUserRepository.deleteById(id);
    }

    @Override
    public List<FtrcUser> getAllUsers() {
        return ftrcUserRepository.findAll();
    }

    @Override
    public FtrcUser findUserById(BigInteger id) {
        return ftrcUserRepository.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
    }

    @Override
    public FtrcUser findUserByFirstNameAndLastName(String firstName, String lastName) {
        return ftrcUserRepository.findFtrcUserByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public FtrcUser findUserByLogin(String login) {
        return ftrcUserRepository.findFtrcUserByLogin(login);
    }

    //UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        FtrcUser user = ftrcUserRepository.findFtrcUserByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) user;
    }
}

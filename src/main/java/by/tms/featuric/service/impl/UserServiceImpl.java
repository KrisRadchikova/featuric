package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.repository.FtrcUserRepository;
import by.tms.featuric.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final FtrcUserRepository ftrcUserRepository;

    @Autowired
    public UserServiceImpl(FtrcUserRepository ftrcUserRepository) {
        this.ftrcUserRepository = ftrcUserRepository;
    }

    @Override
    public FtrcUser save(FtrcUser ftrcUser) {
        return ftrcUserRepository.save(ftrcUser);
    }

    @Override
    public FtrcUser update(BigInteger id, FtrcUser ftrcUser) {
        return null;
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
    public FtrcUser findUserByName(String name) {
        return ftrcUserRepository.findFtrcUserByUserName(name);
    }

    @Override
    public FtrcUser findUserByLogin(String login) {
        return ftrcUserRepository.findFtrcUserByLogin(login);
    }
}

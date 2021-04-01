package by.tms.featuric.service.interfaces;

import by.tms.featuric.entity.FtrcUser;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    FtrcUser save(FtrcUser ftrcUser);

    FtrcUser update(BigInteger id, FtrcUser ftrcUser);

    void deleteById(BigInteger id);

    List<FtrcUser> getAllUsers();

    FtrcUser findUserById(BigInteger id);

    FtrcUser findUserByName(String name);

    FtrcUser findUserByLogin(String login);
}

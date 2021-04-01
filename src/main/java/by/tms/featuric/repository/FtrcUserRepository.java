package by.tms.featuric.repository;

import by.tms.featuric.entity.FtrcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcUserRepository extends JpaRepository<FtrcUser, BigInteger> {
    FtrcUser findFtrcUserByUserName(String name);

    FtrcUser findFtrcUserByLogin(String login);
}

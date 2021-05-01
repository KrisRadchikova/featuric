package by.tms.featuric.repository;

import by.tms.featuric.entity.FtrcAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcAnswerRepository extends JpaRepository<FtrcAnswer, BigInteger> {
    FtrcAnswer findByDescription(String description);
}

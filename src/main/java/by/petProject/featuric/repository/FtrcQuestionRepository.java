package by.petProject.featuric.repository;

import by.petProject.featuric.entity.FtrcQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcQuestionRepository extends JpaRepository<FtrcQuestion, BigInteger> {
    FtrcQuestion findFtrcQuestionByTestId(BigInteger id);

    FtrcQuestion findByName(String name);
}

package by.petProject.featuric.repository;

import by.petProject.featuric.entity.FtrcCategory;
import by.petProject.featuric.entity.FtrcTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcTestRepository extends JpaRepository<FtrcTest, BigInteger> {
    FtrcTest findFtrcTestByCategory(FtrcCategory ftrcCategory);

    FtrcTest findFtrcTestByName(String name);
}

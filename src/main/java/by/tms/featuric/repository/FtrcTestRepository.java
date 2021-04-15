package by.tms.featuric.repository;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcTestRepository extends JpaRepository<FtrcTest, BigInteger> {
    FtrcTest findFtrcTestByCategory(FtrcCategory ftrcCategory);

    FtrcTest findFtrcTestByName(String name);
}

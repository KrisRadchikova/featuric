package by.tms.featuric.repository;

import by.tms.featuric.entity.FtrcCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FtrcCategoryRepository extends JpaRepository<FtrcCategory, BigInteger> {
    FtrcCategory findFtrcCategoryByName(String name);
}

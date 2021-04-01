package by.tms.featuric.service.interfaces;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;

import java.math.BigInteger;
import java.util.List;

public interface TestService {

    FtrcTest save(FtrcTest ftrcTest);

    FtrcTest update(BigInteger id, FtrcTest ftrcTest);

    void deleteTestById(BigInteger id);

    List<FtrcTest> getAllTests();

    FtrcTest findTestById(BigInteger id);

    FtrcTest findTestByCategory(FtrcCategory ftrcCategory);

    FtrcTest findTestByName(String name);
}

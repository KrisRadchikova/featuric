package by.petProject.featuric.service.interfaces;

import by.petProject.featuric.entity.FtrcCategory;
import by.petProject.featuric.entity.FtrcTest;

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

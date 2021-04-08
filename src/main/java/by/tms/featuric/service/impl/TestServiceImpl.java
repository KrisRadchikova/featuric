package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import by.tms.featuric.repository.FtrcTestRepository;
import by.tms.featuric.service.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final FtrcTestRepository ftrcTestRepository;

    @Autowired
    public TestServiceImpl(FtrcTestRepository ftrcTestRepository) {
        this.ftrcTestRepository = ftrcTestRepository;
    }

    @Override
    public FtrcTest save(FtrcTest ftrcTest) {
        return ftrcTestRepository.save(ftrcTest);
    }

    @Override
    public FtrcTest update(BigInteger id, FtrcTest ftrcTestRequest) {
        ftrcTestRepository.findById(id).map(ftrcTest -> {
            ftrcTest.setName(ftrcTestRequest.getName());
            ftrcTest.setImage(ftrcTestRequest.getImage());
            ftrcTest.setDescription(ftrcTestRequest.getDescription());
            ftrcTest.setCategory(ftrcTestRequest.getCategory());
            ftrcTest.setQuestions(ftrcTestRequest.getQuestions());
            return ftrcTestRepository.save(ftrcTest);
        });
        return ftrcTestRequest;
    }

    @Override
    public void deleteTestById(BigInteger id) {
        ftrcTestRepository.deleteById(id);
    }

    @Override
    public List<FtrcTest> getAllTests() {
        return ftrcTestRepository.findAll();
    }

    @Override
    public FtrcTest findTestById(BigInteger id) {
        return ftrcTestRepository.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
    }

    @Override
    public FtrcTest findTestByCategory(FtrcCategory ftrcCategory) {
        return ftrcTestRepository.findFtrcTestByCategory(ftrcCategory);
    }

    @Override
    public FtrcTest findTestByName(String name) {
        return ftrcTestRepository.findFtrcTestByTestName(name);
    }
}

package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import by.tms.featuric.exception.ExistsException;
import by.tms.featuric.exception.IndexOutOfBoundsException;
import by.tms.featuric.exception.NotFoundException;
import by.tms.featuric.repository.FtrcTestRepository;
import by.tms.featuric.service.interfaces.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    private final FtrcTestRepository ftrcTestRepository;

    @Autowired
    public TestServiceImpl(FtrcTestRepository ftrcTestRepository) {
        this.ftrcTestRepository = ftrcTestRepository;
    }

    @Override
    public FtrcTest save(FtrcTest ftrcTest) {
        log.info("Method - save test");
        if (ftrcTestRepository.findFtrcTestByName(ftrcTest.getName()) != null) {
            throw new ExistsException("Test exists");
        }
        return ftrcTestRepository.save(ftrcTest);
    }

    @Override
    public FtrcTest update(BigInteger id, FtrcTest ftrcTestRequest) {
        log.info("Method - update test");
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
        log.info("Method - delete test by ID");
        if (ftrcTestRepository.findById(id).isPresent()) {
            ftrcTestRepository.deleteById(id);
        }
        throw new NotFoundException("Test with id " + id + " not found");
    }

    @Override
    public List<FtrcTest> getAllTests() {
        log.info("Method - get all tests");
        return ftrcTestRepository.findAll();
    }

    @Override
    public FtrcTest findTestById(BigInteger id) {
        log.info("Method - find test by ID");
        return ftrcTestRepository.findById(id).orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public FtrcTest findTestByCategory(FtrcCategory ftrcCategory) {
        log.info("Method - find test by category");
        if (ftrcTestRepository.findById(ftrcCategory.getId()).isPresent()) {
            return ftrcTestRepository.findFtrcTestByCategory(ftrcCategory);
        }
        throw new NotFoundException("There is no test in this category");
    }

    @Override
    public FtrcTest findTestByName(String name) {
        log.info("Method - find test by name");
        return ftrcTestRepository.findFtrcTestByName(name);
    }
}

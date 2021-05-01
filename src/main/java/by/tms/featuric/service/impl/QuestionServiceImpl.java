package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.exception.ExistsException;
import by.tms.featuric.exception.IndexOutOfBoundsException;
import by.tms.featuric.exception.NotFoundException;
import by.tms.featuric.repository.FtrcQuestionRepository;
import by.tms.featuric.repository.FtrcTestRepository;
import by.tms.featuric.service.interfaces.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    private final FtrcQuestionRepository ftrcQuestionRepository;
    private final FtrcTestRepository ftrcTestRepository;

    @Autowired
    public QuestionServiceImpl(FtrcQuestionRepository ftrcQuestionRepository, FtrcTestRepository ftrcTestRepository) {
        this.ftrcQuestionRepository = ftrcQuestionRepository;
        this.ftrcTestRepository = ftrcTestRepository;
    }

    @Override
    public FtrcQuestion save(FtrcQuestion ftrcQuestion) {
        log.info("Method - save question");
        if (ftrcQuestionRepository.findByName(ftrcQuestion.getName()) != null) {
            throw new ExistsException("Question exists");
        }
        return ftrcQuestionRepository.save(ftrcQuestion);
    }

    @Override
    public FtrcQuestion update(BigInteger id, FtrcQuestion ftrcQuestionRequest) {
        log.info("Method - update question");
        ftrcQuestionRepository.findById(id).map(ftrcQuestion -> {
            ftrcQuestion.setName(ftrcQuestionRequest.getName());
            ftrcQuestion.setImage(ftrcQuestionRequest.getImage());
            ftrcQuestion.setDescription(ftrcQuestionRequest.getDescription());
            ftrcQuestion.setAnswers(ftrcQuestionRequest.getAnswers());
            return ftrcQuestionRepository.save(ftrcQuestion);
        });
        return ftrcQuestionRequest;
    }

    @Override
    public void deleteQuestionById(BigInteger id) {
        log.info("Method - delete question by ID");
        if (ftrcQuestionRepository.findById(id).isPresent()) {
            ftrcQuestionRepository.deleteById(id);
        }
        throw new NotFoundException("Question with id " + id + " not found");
    }

    @Override
    public List<FtrcQuestion> getAllQuestions() {
        log.info("Method - get all questions");
        return ftrcQuestionRepository.findAll();
    }

    @Override
    public FtrcQuestion findQuestionById(BigInteger id) {
        log.info("Method - find question by ID");
        return ftrcQuestionRepository.findById(id).orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public FtrcQuestion getQuestionByTestId(BigInteger id) {
        log.info("Method - get question by test ID");
        return ftrcQuestionRepository.findFtrcQuestionByTestId(id);
    }
}

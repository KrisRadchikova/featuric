package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.repository.FtrcQuestionRepository;
import by.tms.featuric.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final FtrcQuestionRepository ftrcQuestionRepository;

    @Autowired
    public QuestionServiceImpl(FtrcQuestionRepository ftrcQuestionRepository) {
        this.ftrcQuestionRepository = ftrcQuestionRepository;
    }

    @Override
    public FtrcQuestion save(FtrcQuestion ftrcQuestion) {
        return ftrcQuestionRepository.save(ftrcQuestion);
    }

    @Override
    public FtrcQuestion update(BigInteger id, FtrcQuestion ftrcQuestion) {
        return null;
    }

    @Override
    public void deleteQuestionById(BigInteger id) {
        ftrcQuestionRepository.deleteById(id);
    }

    @Override
    public List<FtrcQuestion> getAllQuestions() {
        return ftrcQuestionRepository.findAll();
    }

    @Override
    public FtrcQuestion findQuestionById(BigInteger id) {
        return ftrcQuestionRepository.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
    }
}

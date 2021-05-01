package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.exception.ExistsException;
import by.tms.featuric.exception.IndexOutOfBoundsException;
import by.tms.featuric.exception.NotFoundException;
import by.tms.featuric.repository.FtrcAnswerRepository;
import by.tms.featuric.service.interfaces.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService {

    private final FtrcAnswerRepository ftrcAnswerRepository;

    @Autowired
    public AnswerServiceImpl(FtrcAnswerRepository ftrcAnswerRepository) {
        this.ftrcAnswerRepository = ftrcAnswerRepository;
    }


    @Override
    public FtrcAnswer save(FtrcAnswer ftrcAnswer) {
        log.info("Method - save answer");
        if(ftrcAnswerRepository.findByDescription(ftrcAnswer.getDescription()) != null){
            throw new ExistsException("Answer exists");
        }
        return ftrcAnswerRepository.save(ftrcAnswer);
    }

    @Override
    public FtrcAnswer update(BigInteger id, FtrcAnswer ftrcAnswerRequest) {
        log.info("Method - update answer");
        ftrcAnswerRepository.findById(id).map(ftrcAnswer -> {
            ftrcAnswer.setDescription(ftrcAnswerRequest.getDescription());
            ftrcAnswer.setRightAnswer(ftrcAnswerRequest.isRightAnswer());
            ftrcAnswer.setQuestion(ftrcAnswerRequest.getQuestion());
            return ftrcAnswerRepository.save(ftrcAnswer);
        });
        return ftrcAnswerRequest;
    }

    @Override
    public void deleteAnswerById(BigInteger id) {
        log.info("Method - delete answer by ID");
        if (ftrcAnswerRepository.findById(id).isPresent()) {
            ftrcAnswerRepository.deleteById(id);
        } else {
            throw new NotFoundException("Answer with id " + id + " not found");
        }
    }

    @Override
    public FtrcAnswer findAnswerById(BigInteger id) {
        log.info("Method - find answer by ID");
        return ftrcAnswerRepository.findById(id).orElseThrow(IndexOutOfBoundsException::new);
    }
}

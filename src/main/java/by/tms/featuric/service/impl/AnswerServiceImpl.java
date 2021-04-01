package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.repository.FtrcAnswerRepository;
import by.tms.featuric.service.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final FtrcAnswerRepository ftrcAnswerRepository;

    @Autowired
    public AnswerServiceImpl(FtrcAnswerRepository ftrcAnswerRepository) {
        this.ftrcAnswerRepository = ftrcAnswerRepository;
    }


    @Override
    public FtrcAnswer save(FtrcAnswer ftrcAnswer) {
        return ftrcAnswerRepository.save(ftrcAnswer);
    }

    @Override
    public FtrcAnswer update(BigInteger id, FtrcAnswer ftrcAnswer) {
        return null;
    }

    @Override
    public void deleteAnswerById(BigInteger id) {
        ftrcAnswerRepository.deleteById(id);
    }

    @Override
    public FtrcAnswer findAnswerById(BigInteger id) {
        return ftrcAnswerRepository.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
    }
}

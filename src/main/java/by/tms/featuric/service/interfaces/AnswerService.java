package by.tms.featuric.service.interfaces;

import by.tms.featuric.entity.FtrcAnswer;

import java.math.BigInteger;

public interface AnswerService {

    FtrcAnswer save(FtrcAnswer ftrcAnswer);

    FtrcAnswer update(BigInteger id, FtrcAnswer ftrcAnswer);

    void deleteAnswerById(BigInteger id);

    FtrcAnswer findAnswerById(BigInteger id);
}

package by.tms.featuric.service.interfaces;

import by.tms.featuric.entity.FtrcQuestion;

import java.math.BigInteger;
import java.util.List;

public interface QuestionService {

    FtrcQuestion save(FtrcQuestion ftrcQuestion);

    FtrcQuestion update(BigInteger id, FtrcQuestion ftrcQuestion);

    void deleteQuestionById(BigInteger id);

    List<FtrcQuestion> getAllQuestions();

    FtrcQuestion findQuestionById(BigInteger id);
}

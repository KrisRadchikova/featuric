package by.tms.featuric.service.mapper;

import by.tms.featuric.dto.AnswerDto;
import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.service.interfaces.Mapper;
import by.tms.featuric.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper implements Mapper<FtrcAnswer, AnswerDto> {

    private final QuestionService questionService;

    @Autowired
    public AnswerMapper(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public AnswerDto toDto(FtrcAnswer entity) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(entity.getId());
        answerDto.setDescription(entity.getDescription());
        answerDto.setAllAnswers(entity.getAllAnswers());
        answerDto.setRightAnswer(entity.isRightAnswer());
        answerDto.setQuestion(entity.getQuestion());
        return answerDto;
    }

    @Override
    public FtrcAnswer toEntity(AnswerDto dto) {
        FtrcQuestion question = null;
        if (dto.getQuestion() != null) {
            question = questionService.findQuestionById(dto.getQuestion().getId());
        }
        FtrcAnswer answer = new FtrcAnswer();
        answer.setId(dto.getId());
        answer.setDescription(dto.getDescription());
        answer.setAllAnswers(dto.getAllAnswers());
        answer.setRightAnswer(dto.isRightAnswer());
        answer.setQuestion(question);
        return answer;
    }

    @Override
    public AnswerDto toShortDto(FtrcAnswer entity) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(entity.getId());
        answerDto.setDescription(entity.getDescription());
        answerDto.setQuestion(entity.getQuestion());
        return answerDto;
    }
}

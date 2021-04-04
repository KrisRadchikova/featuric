package by.tms.featuric.service.mapper;

import by.tms.featuric.dto.QuestionDto;
import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.service.interfaces.CategoryService;
import by.tms.featuric.service.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper implements Mapper<FtrcQuestion, QuestionDto> {

    private final AnswerMapper answerMapper;
    private final CategoryService categoryService;

    @Autowired
    public QuestionMapper(AnswerMapper answerMapper, CategoryService categoryService) {
        this.answerMapper = answerMapper;
        this.categoryService = categoryService;
    }

    @Override
    public QuestionDto toDto(FtrcQuestion entity) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(entity.getId());
        questionDto.setName(entity.getName());
        questionDto.setAnswerList(entity.getAnswer()
                .stream()
                .map(answerMapper::toDto)
                .collect(Collectors.toList()));

        return questionDto;
    }

    @Override
    public FtrcQuestion toEntity(QuestionDto dto) {
        List<FtrcAnswer> answers = dto.getAnswerList()
                .stream()
                .map(answerMapper::toEntity)
                .collect(Collectors.toList());
        FtrcQuestion question = new FtrcQuestion();
        question.setId(dto.getId());
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setImage(dto.getImage());
        question.setAnswer(answers);
        return question;
    }

    @Override
    public QuestionDto toShortDto(FtrcQuestion entity) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(entity.getId());
        questionDto.setName(entity.getName());
        questionDto.setDescription(entity.getDescription());
        questionDto.setImage(entity.getImage());
        questionDto.setAnswerList(entity.getAnswer()
                .stream()
                .map(answerMapper::toShortDto)
                .collect(Collectors.toList()));
        return questionDto;
    }
}

package by.tms.featuric.resource;

import by.tms.featuric.dto.QuestionDto;
import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.service.interfaces.QuestionService;
import by.tms.featuric.service.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/question")
//TODO create getAllQuestions
public class QuestionResource {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionResource(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestion(@PathVariable BigInteger id) {
        return questionMapper.toDto(questionService.findQuestionById(id));
    }

    @PostMapping("/save")
    public QuestionDto save(@RequestBody QuestionDto questionDto) {
        FtrcQuestion question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionService.save(question));
    }

    @PutMapping("/{id}")
    public QuestionDto update(@PathVariable BigInteger id, @RequestBody QuestionDto questionDto){
        FtrcQuestion question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionService.update(id, question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id){
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok().build();
    }
}

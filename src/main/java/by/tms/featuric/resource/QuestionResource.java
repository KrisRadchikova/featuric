package by.tms.featuric.resource;

import by.tms.featuric.dto.QuestionDto;
import by.tms.featuric.entity.FtrcQuestion;
import by.tms.featuric.service.interfaces.QuestionService;
import by.tms.featuric.service.mapper.QuestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/question")
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
        log.info("GET - get question, path: /question/{id}?id= " + id);
        return questionMapper.toDto(questionService.findQuestionById(id));
    }

    @GetMapping("/getAll")
    public List<QuestionDto> getAll() {
        log.info("GET - get all question, path: /question/getAll");
        return questionService.getAllQuestions().stream()
                .map(questionMapper::toShortDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getByTest/{id}")
    public QuestionDto getQuestionByTestId(@PathVariable BigInteger id) {
        log.info("GET - get question by test ID, path: /question/getByTest/{id}?id= " + id);
        return questionMapper.toDto(questionService.getQuestionByTestId(id));
    }

    @PostMapping("/save")
    public QuestionDto save(@RequestBody QuestionDto questionDto) {
        log.info("POST - save question, path: /question/save");
        FtrcQuestion question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionService.save(question));
    }

    @PutMapping("/{id}")
    public QuestionDto update(@PathVariable BigInteger id, @RequestBody QuestionDto questionDto) {
        log.info("PUT - update question, path: /category/{id}?id= " + id);
        FtrcQuestion question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionService.update(id, question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id) {
        log.info("DELETE - delete question, path: /question/{id}?id= " + id);
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok().build();
    }
}

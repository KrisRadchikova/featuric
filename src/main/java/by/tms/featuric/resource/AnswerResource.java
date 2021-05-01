package by.tms.featuric.resource;

import by.tms.featuric.dto.AnswerDto;
import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.service.interfaces.AnswerService;
import by.tms.featuric.service.mapper.AnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Slf4j
@RestController
@RequestMapping("/answer")
public class AnswerResource {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerResource(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @GetMapping("/{id}")
    public AnswerDto getAnswer(@PathVariable BigInteger id){
        log.info("GET - get answer, path: /answer/{id}?id= " + id);
        return answerMapper.toDto(answerService.findAnswerById(id));
    }

    @PostMapping("/save")
    public AnswerDto save(@RequestBody AnswerDto answerDto){
        log.info("POST - save answer, path: /answer/save");
        FtrcAnswer ftrcAnswer = answerMapper.toEntity(answerDto);
        return answerMapper.toDto(answerService.save(ftrcAnswer));
    }

    @PutMapping("/{id}")
    public AnswerDto updateAnswer(@PathVariable BigInteger id, @RequestBody AnswerDto answerDto){
        log.info("PUT - update answer, path: /answer/{id}?id= " + id);
        FtrcAnswer answer = answerMapper.toEntity(answerDto);
        return answerMapper.toDto(answerService.update(id, answer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable BigInteger id){
        log.info("DELETE - delete answer, path: /answer/{id}?id= " + id);
        answerService.deleteAnswerById(id);
        return ResponseEntity.ok().build();
    }

}

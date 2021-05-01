package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcAnswer;
import by.tms.featuric.service.interfaces.AnswerService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class AnswerServiceTest {

    @Autowired
    private AnswerService answerService;

    @Test
    @Order(1)
    void contextLoads() {
        assertThat(answerService).isNotNull();
    }

    @Test
    @Order(2)
    void save() {
        FtrcAnswer answer = new FtrcAnswer("answer_description", true, null);
        FtrcAnswer saveAnswer = answerService.save(answer);
        assertNotNull(saveAnswer.getId());
        assertEquals(answer.getDescription(), saveAnswer.getDescription());
        assertEquals(answer.isRightAnswer(), saveAnswer.isRightAnswer());
        assertEquals(answer.getQuestion(), saveAnswer.getQuestion());
    }

    @Test
    @Order(4)
    void update() {
        FtrcAnswer updateAnswer = new FtrcAnswer("description", false, null);
        FtrcAnswer saveAnswer = answerService.update(BigInteger.valueOf(1), updateAnswer);
        assertNull(saveAnswer.getId());
        assertEquals(updateAnswer.getDescription(), saveAnswer.getDescription());
        assertEquals(updateAnswer.isRightAnswer(), saveAnswer.isRightAnswer());
        assertEquals(updateAnswer.getQuestion(), saveAnswer.getQuestion());
    }

    @Test
    @Order(5)
    void deleteAnswerById() {
        answerService.deleteAnswerById(BigInteger.valueOf(1));
        Exception exception = null;
        try {
            answerService.findAnswerById(BigInteger.valueOf(1));
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }

    @Test
    @Order(3)
    void findAnswerById() {
        FtrcAnswer answer = answerService.findAnswerById(BigInteger.valueOf(1));
        assertNotNull(answer.getId());
        assertEquals("answer_description", answer.getDescription());
        assertTrue(answer.isRightAnswer());
        assertNull(answer.getQuestion());
    }
}

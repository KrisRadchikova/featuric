package by.tms.featuric.dto;

import by.tms.featuric.entity.FtrcQuestion;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDto {

    BigInteger id;
    String description;
    boolean rightAnswer;
    FtrcQuestion question;
}

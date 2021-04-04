package by.tms.featuric.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestDto {

    BigInteger id;
    String name;
    String image;
    String description;
    String category;
    List<QuestionDto> questions;
}

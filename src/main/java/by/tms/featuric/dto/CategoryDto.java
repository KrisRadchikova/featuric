package by.tms.featuric.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    BigInteger id;
    String name;
    String description;
}

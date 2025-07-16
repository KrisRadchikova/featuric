package by.petProject.featuric.dto;

import by.petProject.featuric.entity.FtrcUserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    BigInteger id;
    String firstName;
    String lastName;
    String image;
    String login;
    String password;
    String email;
    FtrcUserStatus userStatus;
    double rating;

}

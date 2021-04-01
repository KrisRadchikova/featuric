package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FtrcUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotBlank
    @NotEmpty
    private String firstName;

    @NotBlank
    @NotEmpty
    private String lastName;


    @NotBlank
    @NotEmpty
    private String image;

    @NotBlank
    @NotEmpty
    @Size(min = 4, max = 10)
    private String login;

    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @NotBlank
    @NotEmpty
    private FtrcUserStatus userStatus;

    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @NotBlank
    @NotEmpty
    private double rating;
}

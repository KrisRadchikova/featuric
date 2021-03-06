package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(columnDefinition = "numeric(19,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Size(min = 4, max = 20)
    private String login;

    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 999)
    private String password;

    private FtrcUserStatus userStatus;

    @NotBlank
    @NotEmpty
    @Email
    private String email;

    private double rating;

    public FtrcUser(@NotBlank @NotEmpty String firstName, @NotBlank @NotEmpty String lastName, @NotBlank @NotEmpty String image, @NotBlank @NotEmpty @Size(min = 4, max = 20) String login, @NotBlank @NotEmpty @Size(min = 5, max = 999) String password, FtrcUserStatus userStatus, @NotBlank @NotEmpty @Email String email, double rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.login = login;
        this.password = password;
        this.userStatus = userStatus;
        this.email = email;
        this.rating = rating;
    }
}

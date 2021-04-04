package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FtrcAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotBlank
    @NotEmpty
    private String description;

    @NotBlank
    @NotEmpty
    private String allAnswers;

    @NotBlank
    @NotEmpty
    private boolean rightAnswer;

    @ManyToOne
    private FtrcQuestion question;
}

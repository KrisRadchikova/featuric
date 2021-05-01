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
    @Column(columnDefinition = "numeric(19,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @NotBlank
    @NotEmpty
    private String description;

    private boolean rightAnswer;

    @ManyToOne
    private FtrcQuestion question;

    public FtrcAnswer(@NotBlank @NotEmpty String description, boolean rightAnswer, FtrcQuestion question) {
        this.description = description;
        this.rightAnswer = rightAnswer;
        this.question = question;
    }
}

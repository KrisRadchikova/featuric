package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FtrcQuestion {

    @Id
    @Column(columnDefinition = "numeric(19,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String image;

    @NotBlank
    @NotEmpty
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private FtrcTest test;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private List<FtrcAnswer> answers;

    public FtrcQuestion(@NotBlank @NotEmpty String name, @NotBlank @NotEmpty String image, @NotBlank @NotEmpty String description, FtrcTest test, List<FtrcAnswer> answers) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.test = test;
        this.answers = answers;
    }
}

package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Test;

import javax.persistence.*;
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
}

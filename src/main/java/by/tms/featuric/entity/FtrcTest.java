package by.tms.featuric.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FtrcTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotBlank
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private FtrcCategory category;

    @NotBlank
    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<FtrcQuestion> questions;
}

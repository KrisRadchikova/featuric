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
public class FtrcCategory {

    @Id
    @Column(columnDefinition = "numeric(19,0)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String description;

    public FtrcCategory(@NotBlank @NotEmpty String name, @NotBlank @NotEmpty String description) {
        this.name = name;
        this.description = description;
    }
}

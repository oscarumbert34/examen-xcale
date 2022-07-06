package xcale.examen.examen.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ContactDTO {

    private String name;

    @NotBlank
    @Pattern(regexp="[0-9]*")
    private String mobilPhone;
}

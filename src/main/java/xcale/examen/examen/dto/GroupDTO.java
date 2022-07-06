package xcale.examen.examen.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class GroupDTO {

    @NotBlank
    private String name;

    @NotEmpty
    @Valid
    private List<ContactDTO> contacts;
}

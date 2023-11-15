package thewhite.homework.action.create;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateGradeActionArgument {

    @NotNull(message = "не указан id записи")
    Long entryId;

    @NotBlank(message = "не указан комментарий")
    String comment;

    @NotNull(message = "не указан рейтинг")
    @Min(value = 1, message = "оценка не должна быть меньше 1")
    @Max(value = 5, message = "оценка не должна быть больше 5")
    Integer rating;
}

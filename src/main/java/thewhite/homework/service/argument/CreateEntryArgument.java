package thewhite.homework.service.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateEntryArgument {
    String name;
    String description;
    String link;
}

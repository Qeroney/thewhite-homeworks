package thewhite.homework.model;

import lombok.*;

import java.util.UUID;

@Value
@Builder
public class Grade {

    UUID id;
    Long entryId;
    String comment;
    Integer rating;
}

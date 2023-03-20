package ru.netsoft.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Position {
    Long id;
    Long openPrice;
    Integer qnt;
    Instrument instrument;
}

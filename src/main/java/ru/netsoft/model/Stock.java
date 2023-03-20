package ru.netsoft.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Stock implements Instrument {
    Long id;
    String name;
    InstrumentType instrumentType;
}

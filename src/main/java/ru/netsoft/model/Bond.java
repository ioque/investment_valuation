package ru.netsoft.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Bond implements Instrument {
    Long id;
    String name;
    Double coupon;
    Long nominal;
    InstrumentType instrumentType;
}

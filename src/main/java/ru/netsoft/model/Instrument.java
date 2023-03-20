package ru.netsoft.model;

import ru.netsoft.model.InstrumentType;

public interface Instrument {
    Long getId();
    String getName();
    InstrumentType getInstrumentType();
}

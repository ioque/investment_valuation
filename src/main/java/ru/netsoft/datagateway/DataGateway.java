package ru.netsoft.datagateway;

import ru.netsoft.model.Instrument;
import ru.netsoft.model.Portfolio;

import java.util.List;

public interface DataGateway {
    List<Portfolio> getPortfolios();
    Instrument getInstrumentById(Long id);
    Instrument getPortfolioById(Long id);
    Double getMultiplierByInstrumentId(Long instrumentId);
}

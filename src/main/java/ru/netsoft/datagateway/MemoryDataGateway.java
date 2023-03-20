package ru.netsoft.datagateway;

import ru.netsoft.model.*;

import java.util.*;

public class MemoryDataGateway implements DataGateway {
    private final Map<Long, Portfolio> portfolios = new HashMap<>();
    private final Map<Long, Instrument> instruments = new HashMap<>();
    private final Map<Long, Double> instrumentToMultiplier = new HashMap<>();

    public MemoryDataGateway() {
        initInstruments();
        initPortfolios();
    }

    public List<Portfolio> getPortfolios() {
        return new ArrayList<>(portfolios.values());
    }

    public Instrument getInstrumentById(Long id) {
        return instruments.get(id);
    }

    public Portfolio getPortfolioById(Long id) {
        return portfolios.get(id);
    }

    public Double getMultiplierByInstrumentId(Long instrumentId) {
        return instrumentToMultiplier.get(instrumentId);
    }

    private void initPortfolios() {
        List<Position> positionsFirstPortfolio = new ArrayList<>();
        positionsFirstPortfolio.add(Position.builder()
                .id(1L)
                .qnt(100)
                .instrument(instruments.get(1L))
                .openPrice(97000L)
                .build());
        positionsFirstPortfolio.add(Position.builder()
                .id(2L)
                .qnt(20)
                .instrument(instruments.get(2L))
                .openPrice(100000L)
                .build());
        positionsFirstPortfolio.add(Position.builder()
                .id(3L)
                .qnt(1000)
                .instrument(instruments.get(3L))
                .openPrice(1240L)
                .build());
        positionsFirstPortfolio.add(Position.builder()
                .id(4L)
                .qnt(240)
                .instrument(instruments.get(4L))
                .openPrice(20022L)
                .build());
        positionsFirstPortfolio.add(Position.builder()
                .id(5L)
                .qnt(40)
                .instrument(instruments.get(5L))
                .openPrice(9812L)
                .build());
        List<Position> positionsSecondPortfolio = new ArrayList<>();
        positionsSecondPortfolio.add(Position.builder()
                .id(3L)
                .qnt(100)
                .instrument(instruments.get(3L))
                .openPrice(1140L)
                .build());
        positionsSecondPortfolio.add(Position.builder()
                .id(4L)
                .qnt(300)
                .instrument(instruments.get(4L))
                .openPrice(20140L)
                .build());
        positionsSecondPortfolio.add(Position.builder()
                .id(5L)
                .qnt(1000)
                .instrument(instruments.get(5L))
                .openPrice(9613L)
                .build());
        Portfolio firstPortfolio = new Portfolio(1L, positionsFirstPortfolio);
        Portfolio secondPortfolio = new Portfolio(2L, positionsSecondPortfolio);
        portfolios.put(firstPortfolio.getId(), firstPortfolio);
        portfolios.put(secondPortfolio.getId(), secondPortfolio);
    }

    private void initInstruments() {
        Instrument gosBond = Bond.builder()
                .id(1L)
                .coupon(1.07)
                .name("GOS")
                .instrumentType(InstrumentType.BOND)
                .build();
        Instrument comBond = Bond.builder()
                .id(2L)
                .coupon(1.11)
                .name("COM")
                .instrumentType(InstrumentType.BOND)
                .build();
        Instrument afks = Stock.builder()
                .id(3L)
                .name("AFKS")
                .instrumentType(InstrumentType.STOCK)
                .build();
        Instrument sber = Stock.builder()
                .id(4L)
                .name("SBER")
                .instrumentType(InstrumentType.STOCK)
                .build();
        Instrument tinkoff = Stock.builder()
                .id(5L)
                .name("TCS")
                .instrumentType(InstrumentType.STOCK)
                .build();
        instruments.put(gosBond.getId(), gosBond);
        instruments.put(comBond.getId(), comBond);
        instruments.put(afks.getId(), afks);
        instruments.put(sber.getId(), sber);
        instruments.put(tinkoff.getId(), tinkoff);
        instrumentToMultiplier.put(gosBond.getId(), 1.05);
        instrumentToMultiplier.put(comBond.getId(), 0.93);
        instrumentToMultiplier.put(afks.getId(), 1.51);
        instrumentToMultiplier.put(sber.getId(), 1.24);
        instrumentToMultiplier.put(tinkoff.getId(), 0.75);
    }
}

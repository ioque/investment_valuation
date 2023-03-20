package ru.netsoft;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.netsoft.datagateway.DataGateway;
import ru.netsoft.model.Bond;
import ru.netsoft.model.InstrumentType;
import ru.netsoft.model.Portfolio;
import ru.netsoft.model.Position;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Application {
    DataGateway dataGateway;

    public Long run(Long portfolioId) {
        Portfolio portfolio = dataGateway.getPortfolioById(portfolioId);
        long profit = 0L;
        for(Position position : portfolio.getPositions()) {
            long openPrice = position.getOpenPrice();
            double multiplier = dataGateway.getMultiplierByInstrumentId(position.getInstrument().getId());
            double finalPrice = position.getOpenPrice() * multiplier;
            int qnt = position.getQnt();
            if(position.getInstrument().getInstrumentType().equals(InstrumentType.BOND)) {
                Bond bond = (Bond) position.getInstrument();
                profit += ((finalPrice - openPrice) + (finalPrice * bond.getCoupon() - finalPrice)) * qnt;
            } else {
                profit += (finalPrice - openPrice) * qnt;
            }
        }
        return profit;
    }
}

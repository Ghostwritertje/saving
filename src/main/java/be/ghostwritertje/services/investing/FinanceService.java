package be.ghostwritertje.services.investing;

import be.ghostwritertje.domain.investing.FundPurchase;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
public interface FinanceService {
    Double getTotalPortfolio(List<FundPurchase> fundPurchases);

    BigDecimal getCurrentValue(FundPurchase fundPurchase);

    BigDecimal getPriceAtDate(FundPurchase fundPurchase);
}

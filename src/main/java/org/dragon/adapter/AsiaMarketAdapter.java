package org.dragon.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsiaMarketAdapter implements MarketDataService{
    private AsiaMarketProvider marketProvider;
    @Override
    public double getStockPrice(String stockSymbol) {
        return marketProvider.requestStockPrice(stockSymbol);
    }
}

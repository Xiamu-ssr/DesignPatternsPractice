package org.dragon.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class USMarketAdapter implements MarketDataService{
    private USMarketProvider marketProvider;
    @Override
    public double getStockPrice(String stockSymbol) {
        String jsonData = marketProvider.getStockData(stockSymbol);
         JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getDouble("price");
    }
}

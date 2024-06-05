package org.dragon.builder;

/**
 * 股票交易Builder
 *
 * @author mumu
 * @date 2024/06/05
 */
public class StockTradeBuilder implements TradeBuilder{
    private StockTrade stockTrade = new StockTrade();
    @Override
    public void setTradeType(TradeType tradeType) {
        stockTrade.setTradeType(tradeType);
    }

    @Override
    public void setStock(String stock) {
        stockTrade.setStock(stock);
    }

    @Override
    public void setQuantity(int quantity) {
        stockTrade.setQuantity(quantity);
    }

    @Override
    public void setPrice(double price) {
        stockTrade.setPrice(price);
    }

    @Override
    public void setStopLoss(double stopLoss) {
        stockTrade.setStopLoss(stopLoss);
    }

    @Override
    public void setTargetPrice(double targetPrice) {
        stockTrade.setTargetPrice(targetPrice);
    }

    public StockTrade getResult(){
        return stockTrade;
    }

    public void clear(){
        stockTrade = new StockTrade();
    }
}

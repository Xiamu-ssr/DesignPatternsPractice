package org.dragon.builder;

public interface TradeBuilder {
    void setTradeType(TradeType tradeType);
    void setStock(String stock);
    void setQuantity(int quantity);
    void setPrice(double price);
    void setStopLoss(double stopLoss);
    void setTargetPrice(double targetPrice);
}

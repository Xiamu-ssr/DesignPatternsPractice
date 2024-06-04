package org.dragon.factorymethod;

public class TradingPlatform {
    public static void main(String[] args) {
        OrderFactory marketOrderFactory = new MarketOrderFactory();
        Order marketOrder = marketOrderFactory.createOrder("APPLE", 100, true);
        marketOrder.validate();
        marketOrder.execute();

        OrderFactory limitOrderFactory = new LimitOrderFactory(150.50);
        Order limitOrder = limitOrderFactory.createOrder("GOOGLE", 50, false);
        limitOrder.validate();
        limitOrder.execute();
    }
}

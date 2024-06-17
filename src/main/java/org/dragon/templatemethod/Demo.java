package org.dragon.templatemethod;

public class Demo {
    public static void main(String[] args) {
        OrderProcessor marketOrderProcessor = new MarketOrderProcessor();
        marketOrderProcessor.processOrder("AAPL", 100);

        OrderProcessor limitOrderProcessor = new LimitOrderProcessor(150.00);
        limitOrderProcessor.processOrder("AAPL", 100);

        OrderProcessor stopOrderProcessor = new StopOrderProcessor(145.00);
        stopOrderProcessor.processOrder("AAPL", 100);
    }
}

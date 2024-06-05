package org.dragon.builder;

public class TradingPlatform {
    public static void main(String[] args) {

        //使用Director构建预设StockTrade
        StockTradeBuilder builder = new StockTradeBuilder();
        TradeDirector director = new TradeDirector();
        director.constructDayTrading(builder);
        StockTrade dayTrade = builder.getResult();
        System.out.println(dayTrade);

        //手动构建
        builder.clear();
        builder.setTradeType(TradeType.POSITION_TRADING);
        builder.setStock("WD");
        builder.setQuantity(1000);
        builder.setPrice(20.00);
        builder.setStopLoss(19.11);
        builder.setTargetPrice(23.98);
        StockTrade myTrade = builder.getResult();
        System.out.println(myTrade);
    }
}

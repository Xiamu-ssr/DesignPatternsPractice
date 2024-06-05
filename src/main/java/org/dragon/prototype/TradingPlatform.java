package org.dragon.prototype;

public class TradingPlatform {
    public static void main(String[] args) {
        TradeOrder tradeOrder = new TradeOrder("Apple", 100, 10.98, TradeType.DAY_TRADING, new ExtraInfo("Apple company"));

        //浅拷贝
        TradeOrder clone = tradeOrder.clone();
        //修改基本类型和不可变类型，将表现为复制，非同一块内存
        clone.setPrice(12.78);
        clone.setTradeType(TradeType.SWING_TRADING);
        //修改复杂类型，引用的是同一块数据
        tradeOrder.getExtraInfo().setDescription("clone test");

        //深拷贝
        TradeOrder deepClone = tradeOrder.deepClone();
        deepClone.setPrice(13.56);
        deepClone.setTradeType(TradeType.POSITION_TRADING);
        //修改复杂类型，是独立的，不会影响到原对象
        deepClone.getExtraInfo().setDescription("deep clone test");

        //out
        System.out.println(tradeOrder);
        System.out.println(clone);
        System.out.println(deepClone);

    }
}

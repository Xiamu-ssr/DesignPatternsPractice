package org.dragon.builder;

/**
 * 交易 主管
 * <p>内置一些预设好的StockTrade</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public class TradeDirector {
    /**
     * 构建日内交易
     *
     * @param builder 建设者
     */
    public void constructDayTrading(TradeBuilder builder) {
        builder.setTradeType(TradeType.DAY_TRADING);
        builder.setStock("AAPL");
        builder.setQuantity(100);
        builder.setPrice(150.0);
        builder.setStopLoss(148.0);
        builder.setTargetPrice(155.0);
    }

    /**
     * 构造摆动交易
     *
     * @param builder 建设者
     */
    public void constructSwingTrading(TradeBuilder builder) {
        builder.setTradeType(TradeType.SWING_TRADING);
        builder.setStock("MSFT");
        builder.setQuantity(50);
        builder.setPrice(300.0);
        builder.setStopLoss(290.0);
        builder.setTargetPrice(330.0);
    }
}

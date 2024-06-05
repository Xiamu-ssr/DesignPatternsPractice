package org.dragon.builder;

import lombok.Data;

/**
 * 股票交易
 *
 * @author mumu
 * @date 2024/06/04
 */
@Data
public class StockTrade {
    /**
     * 交易类型
     */
    private TradeType tradeType;
    /**
     * 股票代码
     */
    private String stock;
    /**
     * 数量
     */
    private int quantity;
    /**
     * 价格
     */
    private double price;
    /**
     * 止损
     */
    private double stopLoss;
    /**
     * 目标价格
     */
    private double targetPrice;
}

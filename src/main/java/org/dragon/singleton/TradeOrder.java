package org.dragon.singleton;

import lombok.Data;

/**
 * 交易订单
 *
 * @author mumu
 * @date 2024/06/04
 */
@Data
public class TradeOrder {
    private String id;
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

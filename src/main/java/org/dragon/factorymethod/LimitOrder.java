package org.dragon.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 限价订单
 * <p>限价订单允许投资者设定买入或卖出股票的具体价格限制。投资者通过设定一个限价，指示经纪人只有当股票价格达到或更好时（买入订单的限价低于或等于市场价格，卖出订单的限价高于或等于市场价格），才能执行交易。
 * <p>优点：价格可控，只有在达到指定价格或更好价格时才成交。
 * <p>缺点：不能保证成交，如果市场价格未达到指定价格，订单可能一直未被执行。
 *
 * @author mumu
 * @date 2024/06/04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitOrder implements Order{
    /**
     * 要交易的股票的符号
     */
    private String stockSymbol;
    /**
     * 数量股票交易的数量
     */
    private int quantity;
    /**
     * 如果这是一个购买订单为true，否则为false
     */
    private boolean isBuyOrder;
    /**
     * 限价
     */
    private double limitPrice;
    @Override
    public boolean validate() {
        System.out.println(getClass().getSimpleName() + "validate");
        return true;
    }

    @Override
    public boolean execute() {
        if (isBuyOrder) {
            System.out.println("Executing buy limit order for " + quantity + " shares of " + stockSymbol + " at " + limitPrice);
        } else {
            System.out.println("Executing sell limit order for " + quantity + " shares of " + stockSymbol + " at " + limitPrice);
        }
        return true;
    }

    @Override
    public boolean cancel() {
        System.out.println(getClass().getSimpleName() + "cancel");
        return true;
    }
}

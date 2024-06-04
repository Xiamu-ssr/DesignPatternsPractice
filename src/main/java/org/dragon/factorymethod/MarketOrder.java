package org.dragon.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 市价订单
 * <p>市价订单是一种指令，告诉经纪人以当前市场上可获得的最佳价格立即买入或卖出指定数量的股票。市价订单的主要特点是快速成交，确保订单能够被执行，但交易价格可能受市场波动的影响。
 * <p>优点：执行迅速，几乎可以立即成交。
 * <p>缺点：价格不可控，尤其是在市场波动较大时，实际成交价格可能与预期有较大差异。
 *
 * @author mumu
 * @date 2024/06/04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketOrder implements Order{
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
    @Override
    public boolean validate() {
        System.out.println(getClass().getSimpleName() + "validate");
        return true;
    }

    @Override
    public boolean execute() {
        if (isBuyOrder) {
            System.out.println("Executing buy market order for " + quantity + " shares of " + stockSymbol);
        } else {
            System.out.println("Executing sell market order for " + quantity + " shares of " + stockSymbol);
        }
        return true;
    }

    @Override
    public boolean cancel() {
        System.out.println(getClass().getSimpleName() + "cancel");
        return true;
    }
}

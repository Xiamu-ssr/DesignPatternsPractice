package org.dragon.factorymethod;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 限价订单工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
@Data
@AllArgsConstructor
public class LimitOrderFactory extends OrderFactory{
    private double limitPrice;
    @Override
    public Order createOrder(String stockSymbol, int quantity, boolean isBuyOrder) {
        return new LimitOrder(stockSymbol, quantity, isBuyOrder, limitPrice);
    }
}

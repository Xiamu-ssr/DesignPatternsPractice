package org.dragon.factorymethod;

/**
 * 市价订单工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
public class MarketOrderFactory extends OrderFactory{
    @Override
    public Order createOrder(String stockSymbol, int quantity, boolean isBuyOrder) {
        return new MarketOrder(stockSymbol, quantity, isBuyOrder);
    }
}

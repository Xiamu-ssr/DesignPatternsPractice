package org.dragon.factorymethod;

/**
 * 订单工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
public abstract class OrderFactory {
    public abstract Order createOrder(String stockSymbol, int quantity, boolean isBuyOrder);
}

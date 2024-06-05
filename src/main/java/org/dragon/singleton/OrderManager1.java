package org.dragon.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单管理系统1
 * <p>饿汉式</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public class OrderManager1{
    @Getter
    @Setter
    private Map<String, TradeOrder> orders = new HashMap<>();

    @Getter
    private static final OrderManager1 instance = new OrderManager1();

    /**
     * 添加订单
     *
     * @param order 顺序
     */
    public void addOrder(TradeOrder order) {
        orders.put(order.getId(), order);
    }

    /**
     * 获取订单
     *
     * @param orderId 订单id
     * @return {@link TradeOrder}
     */
    public TradeOrder getOrder(String orderId) {
        return orders.get(orderId);
    }


}

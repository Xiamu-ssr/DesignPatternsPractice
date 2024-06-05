package org.dragon.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单管理
 * <p>枚举单例</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public enum OrderManager5 {
    INSTANCE;

    @Getter
    @Setter
    private Map<String, TradeOrder> orders = new HashMap<>();

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

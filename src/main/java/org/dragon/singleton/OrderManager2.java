package org.dragon.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单管理2
 * <p>饱汉式</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public class OrderManager2 {
    @Getter
    @Setter
    private Map<String, TradeOrder> orders = new HashMap<>();

    private static OrderManager2 instance;

    public static OrderManager2 getInstance(){
        if (instance == null){
            instance = new OrderManager2();
        }
        return instance;
    }

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

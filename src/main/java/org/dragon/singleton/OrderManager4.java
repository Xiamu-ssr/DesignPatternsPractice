package org.dragon.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单管理4
 * <p>静态内部类</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public class OrderManager4 {
    @Getter
    @Setter
    private Map<String, TradeOrder> orders = new HashMap<>();

    private static class SingletonHelper{
        private static final OrderManager4 INSTANCE = new OrderManager4();
    }

    public static OrderManager4 getInstance(){
        return SingletonHelper.INSTANCE;
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

package org.dragon.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单管理3
 * <p>饱汉式-线程安全</p>
 *
 * @author mumu
 * @date 2024/06/05
 */
public class OrderManager3 {
    @Getter
    @Setter
    private Map<String, TradeOrder> orders = new HashMap<>();

    private static OrderManager3 instance;

    public static OrderManager3 getInstance(){
        if (instance == null){
            synchronized (OrderManager3.class){
                if (instance == null){
                    instance = new OrderManager3();
                }
            }
            instance = new OrderManager3();
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

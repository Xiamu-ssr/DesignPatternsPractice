package org.dragon.state;

/**
 * 订单状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public interface OrderState {
    void process(Order order);
}

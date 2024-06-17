package org.dragon.state;

/**
 * 取消状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public class CancelledState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order cancelled.");
        // No further state change
    }
}

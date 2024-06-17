package org.dragon.state;

/**
 * 挂单状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public class PendingState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order pending. Moving to partially filled state.");
        order.setState(new PartiallyFilledState());
    }
}

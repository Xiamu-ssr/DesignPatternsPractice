package org.dragon.state;

/**
 * 已创建状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public class CreatedState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order created. Moving to pending state.");
        order.setState(new PendingState());
    }
}

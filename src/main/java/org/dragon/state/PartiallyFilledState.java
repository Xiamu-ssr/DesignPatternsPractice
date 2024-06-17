package org.dragon.state;

/**
 * 部分成交状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public class PartiallyFilledState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order partially filled. Moving to filled state.");
        order.setState(new FilledState());
    }
}

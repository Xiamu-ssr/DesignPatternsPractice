package org.dragon.state;

/**
 * 全部成交状态
 *
 * @author mumu
 * @date 2024/06/17
 */
public class FilledState implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order completely filled.");
        // No further state change
    }
}

package org.dragon.visitor;

/**
 * 止损订单
 *
 * @author mumu
 * @date 2024/06/17
 */
public class StopOrder implements Order{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

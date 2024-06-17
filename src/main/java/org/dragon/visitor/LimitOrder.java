package org.dragon.visitor;

/**
 * 限价订单
 *
 * @author mumu
 * @date 2024/06/17
 */
public class LimitOrder implements Order{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

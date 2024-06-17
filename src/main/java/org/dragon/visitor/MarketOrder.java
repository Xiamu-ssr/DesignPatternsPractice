package org.dragon.visitor;

/**
 * 市场订单
 *
 * @author mumu
 * @date 2024/06/17
 */
public class MarketOrder implements Order{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

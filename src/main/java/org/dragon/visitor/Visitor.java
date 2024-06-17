package org.dragon.visitor;

/**
 * 访问者
 *
 * @author mumu
 * @date 2024/06/17
 */
public interface Visitor {
    void visit(MarketOrder marketOrder);
    void visit(LimitOrder limitOrder);
    void visit(StopOrder stopOrder);
}

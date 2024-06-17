package org.dragon.visitor;

/**
 * 手续费计算器-访问者
 *
 * @author mumu
 * @date 2024/06/17
 */
public class FeeCalculatorVisitor implements Visitor{
    @Override
    public void visit(MarketOrder marketOrder) {
        System.out.println("Calculating fees for market order.");
        // 具体的手续费计算逻辑
    }

    @Override
    public void visit(LimitOrder limitOrder) {
        System.out.println("Calculating fees for limit order.");
        // 具体的手续费计算逻辑
    }

    @Override
    public void visit(StopOrder stopOrder) {
        System.out.println("Calculating fees for stop order.");
        // 具体的手续费计算逻辑
    }
}

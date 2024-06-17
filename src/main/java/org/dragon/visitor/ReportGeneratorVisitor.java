package org.dragon.visitor;

/**
 * 报告生成器-访问者
 *
 * @author mumu
 * @date 2024/06/17
 */
public class ReportGeneratorVisitor implements Visitor{
    @Override
    public void visit(MarketOrder marketOrder) {
        System.out.println("Generating report for market order.");
        // 具体的报告生成逻辑
    }

    @Override
    public void visit(LimitOrder limitOrder) {
        System.out.println("Generating report for limit order.");
        // 具体的报告生成逻辑
    }

    @Override
    public void visit(StopOrder stopOrder) {
        System.out.println("Generating report for stop order.");
        // 具体的报告生成逻辑
    }
}

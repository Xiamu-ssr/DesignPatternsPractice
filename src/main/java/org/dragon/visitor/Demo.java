package org.dragon.visitor;

public class Demo {
    public static void main(String[] args) {
        Order marketOrder = new MarketOrder();
        Order limitOrder = new LimitOrder();
        Order stopOrder = new StopOrder();

        Visitor feeCalculator = new FeeCalculatorVisitor();
        Visitor reportGenerator = new ReportGeneratorVisitor();

        marketOrder.accept(feeCalculator);
        limitOrder.accept(feeCalculator);
        stopOrder.accept(feeCalculator);

        marketOrder.accept(reportGenerator);
        limitOrder.accept(reportGenerator);
        stopOrder.accept(reportGenerator);
    }
}

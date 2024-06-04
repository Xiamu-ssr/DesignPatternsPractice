package org.dragon.abstractfactory;

/**
 * 美国市场 工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
public class USTradingFactory implements TradingFactory{
    @Override
    public Order createOrder() {
        return new USOrder();
    }

    @Override
    public AnalysisTool createAnalysisTool() {
        return new USAnalysisTool();
    }
}

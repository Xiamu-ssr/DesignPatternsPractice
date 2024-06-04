package org.dragon.abstractfactory;

/**
 * 欧洲市场 工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
public class EUTradingFactory implements TradingFactory{
    @Override
    public Order createOrder() {
        return new EUOrder();
    }

    @Override
    public AnalysisTool createAnalysisTool() {
        return new EUAnalysisTool();
    }
}

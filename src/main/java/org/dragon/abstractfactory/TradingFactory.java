package org.dragon.abstractfactory;

/**
 * 贸易工厂
 *
 * @author mumu
 * @date 2024/06/04
 */
public interface TradingFactory {
    /**
     * 创建订单
     *
     * @return {@link Order}
     */
    Order createOrder();

    /**
     * 创建分析工具
     *
     * @return {@link AnalysisTool}
     */
    AnalysisTool createAnalysisTool();
}

package org.dragon.adapter;

/**
 * 市场数据服务
 *
 * @author mumu
 * @date 2024/06/06
 */
public interface MarketDataService {
    /**
     * 获取股票价格
     *
     * @param stockSymbol 股票符号
     * @return double
     */
    double getStockPrice(String stockSymbol);
}

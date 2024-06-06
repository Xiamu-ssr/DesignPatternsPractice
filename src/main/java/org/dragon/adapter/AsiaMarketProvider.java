package org.dragon.adapter;

/**
 * 亚洲市场提供商
 *
 * @author mumu
 * @date 2024/06/06
 */
public class AsiaMarketProvider {
    public double requestStockPrice(String stockSymbol) {
        // 模拟返回直接的股票价格
        return Math.random() * 1000;
    }
}

package org.dragon.adapter;

/**
 * 美国市场提供商
 *
 * @author mumu
 * @date 2024/06/06
 */
public class USMarketProvider {
    public String getStockData(String stockSymbol) {
        // 模拟返回 JSON 格式的股票数据
        return "{\"symbol\": \"" + stockSymbol + "\", \"price\": " + (Math.random() * 1000) + "}";
    }
}

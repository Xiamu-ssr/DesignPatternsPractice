package org.dragon.adapter;

/**
 * 欧洲市场供应商
 *
 * @author mumu
 * @date 2024/06/06
 */
public class EUMarketProvider {
    public String fetchStockInfo(String stockSymbol) {
        // 模拟返回 XML 格式的股票数据
        return "<stock><symbol>" + stockSymbol + "</symbol><price>" + (Math.random() * 1000) + "</price></stock>";
    }
}

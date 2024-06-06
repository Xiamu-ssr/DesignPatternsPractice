package org.dragon.adapter;

public class MarketDataSystem {
    public static void main(String[] args) {
        // 创建不同市场的数据提供商实例
        USMarketProvider usProvider = new USMarketProvider();
        EUMarketProvider euProvider = new EUMarketProvider();
        AsiaMarketProvider asiaProvider = new AsiaMarketProvider();

        // 使用适配器将提供商适配成统一的接口
        MarketDataService usMarketService = new USMarketAdapter(usProvider);
        MarketDataService euMarketService = new EUMarketAdapter(euProvider);
        MarketDataService asiaMarketService = new AsiaMarketAdapter(asiaProvider);

        // 使用统一的接口获取股票价格
        System.out.println("US Market price of AAPL: $" + usMarketService.getStockPrice("AAPL"));
        System.out.println("EU Market price of AAPL: $" + euMarketService.getStockPrice("AAPL"));
        System.out.println("Asia Market price of AAPL: $" + asiaMarketService.getStockPrice("AAPL"));
    }
}

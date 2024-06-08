package org.dragon.proxy;

public class Demo {
    public static void main(String[] args) {
        // 创建代理对象
        StockTrading proxy = new StockTradingProxy("admin");
        proxy.buyStock("AAPL", 100);
        proxy.sellStock("AAPL", 50);

        System.out.println();

        // 非管理员尝试交易
        StockTrading nonAdminProxy = new StockTradingProxy("guest");
        nonAdminProxy.buyStock("AAPL", 100);
        nonAdminProxy.sellStock("AAPL", 50);
    }
}

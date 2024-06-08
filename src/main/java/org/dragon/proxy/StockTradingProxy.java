package org.dragon.proxy;

/**
 * 股票交易代理
 *
 * @author mumu
 * @date 2024/06/08
 */
public class StockTradingProxy implements StockTrading{
    private RealStockTrading realStockTrading;
    private String userRole;

    public StockTradingProxy(String userRole) {
        this.userRole = userRole;
        this.realStockTrading = new RealStockTrading();
    }

    /**
     * 是否拥有权限
     *
     * @return boolean
     */
    private boolean hasPermission() {
        // 假设只有 "admin" 角色有权限执行交易
        return "admin".equalsIgnoreCase(userRole);
    }

    /**
     * 日志事务
     *
     * @param action   行动
     * @param stock    股票
     * @param quantity 量
     */
    private void logTransaction(String action, String stock, int quantity) {
        System.out.println("Logging transaction: " + action + " " + quantity + " shares of " + stock);
    }
    @Override
    public void buyStock(String stock, int quantity) {
        if (hasPermission()) {
            realStockTrading.buyStock(stock, quantity);
            logTransaction("buy", stock, quantity);
        } else {
            System.out.println("Permission denied: You do not have permission to buy stocks.");
        }
    }

    @Override
    public void sellStock(String stock, int quantity) {
        if (hasPermission()) {
            realStockTrading.sellStock(stock, quantity);
            logTransaction("sell", stock, quantity);
        } else {
            System.out.println("Permission denied: You do not have permission to sell stocks.");
        }
    }
}

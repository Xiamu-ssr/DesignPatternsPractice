package org.dragon.proxy;

/**
 * 股票交易
 *
 * @author mumu
 * @date 2024/06/08
 */
public interface StockTrading {
    /**
     * 买入股票
     *
     * @param stock    股票
     * @param quantity 量
     */
    void buyStock(String stock, int quantity);

    /**
     * 出售股票
     *
     * @param stock    股票
     * @param quantity 量
     */
    void sellStock(String stock, int quantity);
}

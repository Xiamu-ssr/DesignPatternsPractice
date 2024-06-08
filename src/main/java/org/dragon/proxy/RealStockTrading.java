package org.dragon.proxy;

/**
 * 真实股票交易
 *
 * @author mumu
 * @date 2024/06/08
 */
public class RealStockTrading implements StockTrading{
    @Override
    public void buyStock(String stock, int quantity) {
        System.out.println("Buying " + quantity + " shares of " + stock);
    }

    @Override
    public void sellStock(String stock, int quantity) {
        System.out.println("Selling " + quantity + " shares of " + stock);
    }
}

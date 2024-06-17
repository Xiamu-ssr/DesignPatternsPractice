package org.dragon.templatemethod;

/**
 * 市场订单处理器
 *
 * @author mumu
 * @date 2024/06/17
 */
public class MarketOrderProcessor extends OrderProcessor{
    @Override
    protected void selectStock(String stock) {
        System.out.println("Selecting stock: " + stock);
    }

    @Override
    protected void validateOrder(int quantity) {
        System.out.println("Validating market order for quantity: " + quantity);
    }

    @Override
    protected void placeOrder(String stock, int quantity) {
        System.out.println("Placing market order for " + quantity + " shares of " + stock);
    }
}

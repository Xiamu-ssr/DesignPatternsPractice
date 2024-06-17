package org.dragon.templatemethod;

import lombok.AllArgsConstructor;

/**
 * 限价订单处理器
 *
 * @author mumu
 * @date 2024/06/17
 */
@AllArgsConstructor
public class LimitOrderProcessor extends OrderProcessor{
    private double limitPrice;

    @Override
    protected void selectStock(String stock) {
        System.out.println("Selecting stock: " + stock);
    }

    @Override
    protected void validateOrder(int quantity) {
        System.out.println("Validating limit order for quantity: " + quantity + " at limit price: $" + limitPrice);
    }

    @Override
    protected void placeOrder(String stock, int quantity) {
        System.out.println("Placing limit order for " + quantity + " shares of " + stock + " at $" + limitPrice);
    }
}

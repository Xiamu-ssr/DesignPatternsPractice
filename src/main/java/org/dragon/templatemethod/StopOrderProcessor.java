package org.dragon.templatemethod;

import lombok.AllArgsConstructor;

/**
 * 止损订单处理器
 *
 * @author mumu
 * @date 2024/06/17
 */
@AllArgsConstructor
public class StopOrderProcessor extends OrderProcessor{
    private double stopPrice;

    @Override
    protected void selectStock(String stock) {
        System.out.println("Selecting stock: " + stock);
    }

    @Override
    protected void validateOrder(int quantity) {
        System.out.println("Validating stop order for quantity: " + quantity + " at stop price: $" + stopPrice);
    }

    @Override
    protected void placeOrder(String stock, int quantity) {
        System.out.println("Placing stop order for " + quantity + " shares of " + stock + " at $" + stopPrice);
    }
}

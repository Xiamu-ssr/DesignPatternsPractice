package org.dragon.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 股票
 *
 * @author mumu
 * @date 2024/06/07
 */
@Data
@AllArgsConstructor
public class Stock implements FinancialComponent{
    private String name;
    private double price;
    private int quantity;
    @Override
    public void display() {
        System.out.println("Stock: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }

    @Override
    public double getValue() {
        return price * quantity;
    }
}

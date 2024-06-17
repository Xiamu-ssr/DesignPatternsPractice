package org.dragon.observer;

/**
 * 投资者
 *
 * @author mumu
 * @date 2024/06/17
 */
public class Investor implements Observer{
    private String name;
    private Stock stock;

    public Investor(String name, Stock stock) {
        this.name = name;
        this.stock = stock;
        stock.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Investor " + name + " notified. New price of " + stock.getSymbol() + " is " + stock.getPrice());
    }
}

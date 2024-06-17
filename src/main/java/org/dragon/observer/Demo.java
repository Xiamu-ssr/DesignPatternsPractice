package org.dragon.observer;

public class Demo {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.00);
        Investor investor1 = new Investor("John Doe", appleStock);
        Investor investor2 = new Investor("Jane Smith", appleStock);

        // Change stock price
        appleStock.changePrice(151.00);
        appleStock.changePrice(152.50);
    }
}

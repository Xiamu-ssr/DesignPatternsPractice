package org.dragon.state;

import lombok.Data;

@Data
public class Order {
    private OrderState state;
    private String stockSymbol;
    private int quantity;
    private double price;

    public Order(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.state = new CreatedState(); // Initial state
    }
    public void setState(OrderState state) {
        this.state = state;
    }

    public void processOrder() {
        state.process(this);
    }
}

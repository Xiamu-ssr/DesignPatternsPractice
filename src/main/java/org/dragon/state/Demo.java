package org.dragon.state;

public class Demo {
    public static void main(String[] args) {
        Order order = new Order("AAPL", 100, 150.0);

        order.processOrder();
        order.processOrder();
        order.processOrder();
        order.processOrder();

        // 模拟取消订单的流程
        Order cancelledOrder = new Order("GOOG", 50, 2500.0);
        cancelledOrder.processOrder();
        cancelledOrder.setState(new CancelledState());
        cancelledOrder.processOrder();
    }
}

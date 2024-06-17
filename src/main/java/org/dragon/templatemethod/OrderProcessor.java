package org.dragon.templatemethod;

/**
 * 订单处理器
 *
 * @author mumu
 * @date 2024/06/17
 */
public abstract class OrderProcessor {
    public final void processOrder(String stock, int quantity) {
        //选择股票
        selectStock(stock);
        //验证订单
        validateOrder(quantity);
        //如果市场开放，则下单
        if (isMarketOpen()) {
            placeOrder(stock, quantity);
        } else {
            System.out.println("Market is closed. Cannot place order.");
        }
        //确认订单
        confirmOrder();
    }

    protected abstract void selectStock(String stock);

    protected abstract void validateOrder(int quantity);

    protected abstract void placeOrder(String stock, int quantity);

    protected void confirmOrder() {
        System.out.println("Order has been confirmed.");
    }

    protected boolean isMarketOpen() {
        // 假设市场开放时间为9:00到16:00
        int hour = java.time.LocalTime.now().getHour();
        return hour >= 9 && hour <= 16;
    }
}

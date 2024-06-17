package org.dragon.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 股票
 *
 * @author mumu
 * @date 2024/06/17
 */
@Data
@AllArgsConstructor
public class Stock extends Subject{
    private String symbol;
    private double price;

    /**
     * 变更价格
     * <BR/>变更价格后会通知所有目前正在关注这支股票的用户
     *
     * @param price 价格
     */
    public void changePrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

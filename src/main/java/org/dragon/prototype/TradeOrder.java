package org.dragon.prototype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 交易订单
 *
 * @author mumu
 * @date 2024/06/05
 */
@Data
@AllArgsConstructor
@SuperBuilder
public class TradeOrder implements Cloneable, DeepCloneable<TradeOrder>{
    private String stockSymbol;
    private int quantity;
    private double price;
    private TradeType tradeType;
    private ExtraInfo extraInfo;

    /**
     * 拷贝构造函数
     *
     * @param other 另外
     */
    public TradeOrder(TradeOrder other) {
        this.stockSymbol = other.stockSymbol;
        this.quantity = other.quantity;
        this.price = other.price;
        this.tradeType = other.tradeType;
        this.extraInfo = other.extraInfo;
    }

    @Override
    public TradeOrder clone() {
        try {
            return (TradeOrder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public TradeOrder deepClone() {
        return new TradeOrder(this);
    }
}

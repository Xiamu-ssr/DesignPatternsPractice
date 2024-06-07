package org.dragon.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.*;

@Data
@AllArgsConstructor
@SuperBuilder
public class TradeOrder2 implements Cloneable, DeepCloneable<TradeOrder2>, Serializable {
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
    public TradeOrder2(TradeOrder2 other) {
        this.stockSymbol = other.stockSymbol;
        this.quantity = other.quantity;
        this.price = other.price;
        this.tradeType = other.tradeType;
        this.extraInfo = other.extraInfo;
    }

    @Override
    public TradeOrder2 clone() {
        try {
            return (TradeOrder2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public TradeOrder2 deepClone() {
        try {
            // 序列化
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(this);

            // 反序列化
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            return (TradeOrder2) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

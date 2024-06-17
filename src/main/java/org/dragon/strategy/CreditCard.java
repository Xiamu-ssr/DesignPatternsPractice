package org.dragon.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 信用卡
 *
 * @author mumu
 * @date 2024/06/17
 */
public class CreditCard {
    @Getter
    @Setter
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
}

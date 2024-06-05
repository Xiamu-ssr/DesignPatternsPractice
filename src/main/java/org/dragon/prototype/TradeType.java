package org.dragon.prototype;

import lombok.Getter;

/**
 * 交易类型
 *
 * @author mumu
 * @date 2024/06/05
 */
@Getter
public enum TradeType {
    DAY_TRADING("日内交易"),
    SWING_TRADING("摆动交易"),
    POSITION_TRADING("趋势交易"),
    SCALPING("剥头皮交易");

    private final String description;

    TradeType(String description) {
        this.description = description;
    }

}

package org.dragon.strategy;

/**
 * 支付策略接口
 *
 * @author mumu
 * @date 2024/06/17
 */
public interface PayStrategy {
    /**
     * 支付
     *
     * @param paymentAmount 付款金额
     * @return boolean
     */
    boolean pay(int paymentAmount);

    /**
     * 登录
     */
    void collectPaymentDetails();
}

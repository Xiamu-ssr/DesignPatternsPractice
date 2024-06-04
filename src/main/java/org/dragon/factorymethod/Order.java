package org.dragon.factorymethod;

/**
 * 订单
 *
 * @author mumu
 * @date 2024/06/04
 */
public interface Order {
    /**
     * 验证订单合法性
     */
    boolean validate();

    /**
     * 执行订单
     */
    boolean execute();

    /**
     * 取消订单
     */
    boolean cancel();
}

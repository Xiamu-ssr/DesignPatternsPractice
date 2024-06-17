package org.dragon.visitor;

/**
 * 订单
 * <BR/>元素接口，accept方法接受访问
 *
 * @author mumu
 * @date 2024/06/17
 */
public interface Order {
    void accept(Visitor visitor);
}

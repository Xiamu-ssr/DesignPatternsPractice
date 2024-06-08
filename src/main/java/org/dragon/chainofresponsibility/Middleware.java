package org.dragon.chainofresponsibility;

/**
 * 基础验证抽象
 *
 * @author mumu
 * @date 2024/06/08
 */
public abstract class Middleware {
    private Middleware next;

    /**
     * 构建责任链
     *
     * @param first 第一
     * @param chain 链条
     * @return {@link Middleware}
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * 检查
     *
     * @param user 使用者
     * @return boolean
     */
    public abstract boolean check(User user);

    /**
     * 检查下一个
     *
     * @param user 使用者
     * @return boolean
     */
    protected boolean checkNext(User user) {
        if (next == null) {
            return true;
        }
        return next.check(user);
    }
}

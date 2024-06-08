package org.dragon.chainofresponsibility;

/**
 * 请求频率中间链
 *
 * @author mumu
 * @date 2024/06/08
 */
public class ThrottlingMiddleware extends Middleware{
    private int requestPerMinute;
    private int request;
    private long currentTime;
    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }
    @Override
    public boolean check(User user) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            return false;
        }
        return checkNext(user);
    }
}

package org.dragon.chainofresponsibility;

import lombok.AllArgsConstructor;

/**
 * 用户存在中间链
 *
 * @author mumu
 * @date 2024/06/08
 */
@AllArgsConstructor
public class UserExistsMiddleware extends Middleware{
    private Server server;
    @Override
    public boolean check(User user) {
        if (!server.hasEmail(user.getEmail())) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(user.getEmail(), user.getPassword())) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(user);
    }
}

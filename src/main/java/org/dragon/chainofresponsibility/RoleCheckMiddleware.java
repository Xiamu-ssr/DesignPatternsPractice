package org.dragon.chainofresponsibility;

/**
 * 角色检查中间链
 *
 * @author mumu
 * @date 2024/06/08
 */
public class RoleCheckMiddleware extends Middleware{
    @Override
    public boolean check(User user) {
        if (user.getRole() == UserRole.ADMIN) {
            System.out.println("Hello, admin!");
            return true;
        }else if (user.getRole() == UserRole.GUEST){
            System.out.println("Warning, Guest is blocked!");
            return false;
        }
        System.out.println("Hello, user!");
        return checkNext(user);
    }
}

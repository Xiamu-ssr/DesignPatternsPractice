package org.dragon.chainofresponsibility;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户数据服务器
 *
 * @author mumu
 * @date 2024/06/08
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Map<String, UserRole> roles = new HashMap<>();
    @Setter
    private Middleware middleware;
    public String logIn(String email, String password) {
        //如果用户存在，则授予token
        if (hasEmail(email) && isValidPassword(email, password)) {
            System.out.println("Authorization have been successful!");
            User user = new User(email, password, roles.get(email));
            return JwtUtil.generateToken(user);
        }
        return "";
    }

    public boolean handleRequest(String token) {
        User user;
        try {
            user = JwtUtil.parseToken(token);
        } catch (Exception e) {
            System.out.println("Invalid JWT token!");
            return false;
        }

        if (middleware.check(user)) {
            System.out.println("Authorization have been successful!");
            return true;
        }
        return false;
    }

    public void register(String email, String password, UserRole role) {
        users.put(email, password);
        roles.put(email, role);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }

    public UserRole getRole(String email) {
        return roles.get(email);
    }

}

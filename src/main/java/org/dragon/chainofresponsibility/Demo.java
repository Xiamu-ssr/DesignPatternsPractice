package org.dragon.chainofresponsibility;

import java.util.ArrayList;

public class Demo {
    private static Server server;
    public static void main(String[] args) {
        //初始化
        init();
        //填入要登录的用户，用于测试
        ArrayList<String[]> userList = new ArrayList<>();
        userList.add(new String[]{"admin@example.com", "admin_pass"});
        userList.add(new String[]{"user@example.com", "user_pass"});
        userList.add(new String[]{"guest@example.com", "guest_pass"});
        userList.add(new String[]{"guest@example.com", "guest_pass"});
        userList.add(new String[]{"admin@example.com", "error_pass"});
        userList.add(new String[]{"user@example.com", "error_pass"});
        userList.add(new String[]{"guest@example.com", "error_pass"});

        for (String[] loginUser : userList) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //先login获取token
            String token = server.logIn(loginUser[0], loginUser[1]);
            if (token.isBlank()){
                System.out.println("密码错误或者用户不存在");
                continue;
            }
            //用token去请求
            boolean b = server.handleRequest(token);
        }
    }

    private static void init() {
        //注册用户
        server = new Server();
        server.register("admin@example.com", "admin_pass", UserRole.ADMIN);
        server.register("user@example.com", "user_pass", UserRole.CONSUMER);
        server.register("guest@example.com", "guest_pass", UserRole.GUEST);

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(3),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );
        server.setMiddleware(middleware);
    }
}

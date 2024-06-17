package org.dragon.mediator;

/**
 * 聊天用户
 *
 * @author mumu
 * @date 2024/06/17
 */
public class User extends Colleague{
    public User(String name) {
        super(name);
    }
    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

package org.dragon.mediator;

/**
 * 同事
 *
 * @author mumu
 * @date 2024/06/17
 */
public abstract class Colleague {
    protected Mediator mediator;
    protected String name;

    public Colleague(String name) {
        this.mediator = ChatRoom.INSTANCE;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

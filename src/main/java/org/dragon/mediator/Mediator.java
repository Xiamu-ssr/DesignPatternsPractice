package org.dragon.mediator;

/**
 * 中介者
 *
 * @author mumu
 * @date 2024/06/17
 */
public interface Mediator {
    void sendMessage(String message, Colleague sender);
    void addColleague(Colleague colleague);
}

package org.dragon.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室-作为聊天用户的中介者
 *
 * @author mumu
 * @date 2024/06/17
 */
public enum ChatRoom implements Mediator{
    INSTANCE;

    private List<Colleague> colleagues;

    ChatRoom(){
        colleagues = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            // 消息不发送给发送者自己
            if (colleague != sender) {
                colleague.receive(message);
            }
        }
    }

    @Override
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
}

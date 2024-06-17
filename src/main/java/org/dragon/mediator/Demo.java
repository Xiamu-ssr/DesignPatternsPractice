package org.dragon.mediator;

public class Demo {
    public static void main(String[] args) {
        Colleague user1 = new User("User1");
        Colleague user2 = new User("User2");
        Colleague user3 = new User("User3");

        ChatRoom chatRoom = ChatRoom.INSTANCE;

        chatRoom.addColleague(user1);
        chatRoom.addColleague(user2);
        chatRoom.addColleague(user3);

        user1.send("Hello, everyone!");
        user2.send("Hi, User1!");
        user3.send("Hey!");
    }
}

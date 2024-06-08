package org.dragon.command;

import java.util.Stack;

/**
 * 命令历史记录
 *
 * @author mumu
 * @date 2024/06/08
 */
public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}

package org.dragon.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录管理员
 *
 * @author mumu
 * @date 2024/06/17
 */
public class Caretaker {
    private List<TextEditorMemento> mementos = new ArrayList<>();

    /**
     * 添加快照
     *
     * @param memento 纪念品
     */
    public void addMemento(TextEditorMemento memento) {
        mementos.add(memento);
    }

    /**
     * 获取快照
     *
     * @param index 指数
     * @return {@link TextEditorMemento}
     */
    public TextEditorMemento getMemento(int index) {
        return mementos.get(index);
    }
}

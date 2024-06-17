package org.dragon.memento;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本编辑器
 *
 * @author mumu
 * @date 2024/06/17
 */
@Data
public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> styles;

    /**
     * 保存状态
     *
     * @return {@link TextEditorMemento}
     */
    public TextEditorMemento save() {
        return new TextEditorMemento(content, cursorPosition);
    }

    /**
     * 恢复
     *
     * @param memento 纪念品
     */
    public void restore(TextEditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.styles = new ArrayList<>();
    }
}

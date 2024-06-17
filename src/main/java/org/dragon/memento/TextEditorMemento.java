package org.dragon.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 文本编辑器-备忘录
 * <BR/>只保存文本信息和光标位置两种属性的状态
 *
 * @author mumu
 * @date 2024/06/17
 */
@Data
@AllArgsConstructor
public class TextEditorMemento{
    private String content;
    private int cursorPosition;
}

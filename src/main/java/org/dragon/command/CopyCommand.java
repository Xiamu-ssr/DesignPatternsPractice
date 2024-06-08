package org.dragon.command;

/**
 * 复制命令-命令执行者
 *
 * @author mumu
 * @date 2024/06/08
 */
public class CopyCommand extends Command{
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}

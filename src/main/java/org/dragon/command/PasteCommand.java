package org.dragon.command;

/**
 * 粘贴命令-命令执行者
 *
 * @author mumu
 * @date 2024/06/08
 */
public class PasteCommand extends Command{
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}

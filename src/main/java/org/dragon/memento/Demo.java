package org.dragon.memento;

public class Demo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setContent("测试1，测试1");
        editor.setCursorPosition(1);
        caretaker.addMemento(editor.save());

        editor.setContent("测试2，测试2");
        editor.setCursorPosition(2);
        caretaker.addMemento(editor.save());

        editor.setContent("测试3，测试3");
        editor.setCursorPosition(3);
        caretaker.addMemento(editor.save());

        editor.restore(caretaker.getMemento(0));
        System.out.println(editor.toString());
        editor.restore(caretaker.getMemento(2));
        System.out.println(editor.toString());
        editor.restore(caretaker.getMemento(1));
        System.out.println(editor.toString());


    }
}

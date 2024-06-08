package org.dragon.flyweight;

import lombok.AllArgsConstructor;

import java.awt.*;

/**
 * 树
 *
 * @author mumu
 * @date 2024/06/08
 */
@AllArgsConstructor
public class Tree {
    private int x;
    private int y;
    private TreeType type;
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(type.getColor());
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}

package org.dragon.flyweight;

public class Demo {
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1_000_000;
    static int TREE_TYPES = TreeType.values().length;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), TreeType.PINE_TREE);
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), TreeType.GINGKO);
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), TreeType.RED_MAPLE);
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        // 内存使用估计
        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES);
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                " MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + " MB)");

    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}

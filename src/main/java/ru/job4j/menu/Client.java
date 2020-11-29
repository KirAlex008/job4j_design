package ru.job4j.menu;

public class Client {
    public static void main(String[] args) {
        boolean rsl = true;
        Input input = new ConsoleInput();
        ExampleAction action = new ExampleAction();
        MenuItem item1 = new MenuItem("Задача 1.", 1, action);
        MenuItem item2 = new MenuItem("---- Задача 1.1.", 2, action);
        MenuItem item3 = new MenuItem("--------- Задача 1.1.1.", 3, action);
        MenuItem item4 = new MenuItem("--------- Задача 1.1.2.", 4, action);
        MenuItem item5 = new MenuItem("----- Задача 1.2.", 5, action);
        TreeNode root = new TreeNode(item1);
        TreeNode child = root.addChild(item2);
        child.addChild(item3);
        child.addChild(item4);
        child = root.addChild(item5);
        root.printTree(root);
        String select = input.askStr("Select: ");
        MenuItem choice;
        choice = root.find(select, root);
        rsl = choice.getAction().execute();
    }
}

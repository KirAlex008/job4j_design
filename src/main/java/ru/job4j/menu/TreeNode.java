package ru.job4j.menu;

public class TreeNode<T> implements AddNode<T>, TraverseTree<T>, ShowAll<T>, FindNode<T> {
    private T value = null;
    private TreeNode[] childrens = new TreeNode[100];
    private int childCount = 0;

    TreeNode(T value) {
        this.value = value;
    }

    @Override
    public void printTree(TreeNode obj) {
        System.out.println(obj.value.toString());
        traverse(obj);
    }

    @Override
    public TreeNode addChild(Object value) {
        TreeNode newChild = new TreeNode(value);
        childrens[childCount++] = newChild;
        return newChild;
    }

    @Override
    public MenuItem find(String string, T object) {
        MenuItem rsl = null;
        TreeNode obj;
        obj = (TreeNode) object;
        if (obj.value.toString().equals(string)) {
            rsl = (MenuItem) obj.value;
        }
            for (int i = 0; i < obj.childCount; i++) {
                if (obj.childrens[i].value.toString().equals(string)) {
                    rsl = (MenuItem) obj.childrens[i].value;
                    break;
                }
                find(string, (T) obj.childrens[i]);
            }
        return rsl;
    }

    @Override
    public void traverse(TreeNode obj) {
        if (obj != null) {
            for (int i = 0; i < obj.childCount; i++) {
                System.out.println(obj.childrens[i].value + "1 DDD");
                traverse(obj.childrens[i]);
            }
        }
    }


}

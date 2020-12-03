package ru.job4j.menu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T> implements AddNode<T>, TraverseTree<T>, ShowAll<T>, FindNode<T> {
    private T value = null;
    private List<TreeNode> childrens = new ArrayList<>();
    private int childCount = 0;

    TreeNode(T value) {
        this.value = value;
    }

    @Override
    public void printTree(TreeNode obj) {
        System.out.println(obj.getValue().toString());
        traverse(obj);
    }

    @Override
    public void traverse(TreeNode obj) {
        if (obj != null) {
            for (int i = 0; i < obj.getChildrens().size(); i++) {
                TreeNode objTree1 = (TreeNode) obj.getChildrens().get(i);
                System.out.println(objTree1.getValue().toString());
                traverse((TreeNode) obj.getChildrens().get(i));
            }
        }
    }

    @Override
    public TreeNode addChild(Object value) {
        TreeNode newChild = new TreeNode(value);
        int counter;
        counter = this.getChildCount();
        counter++;
        this.getChildrens().add(newChild);
        return newChild;
    }

     @Override
    public MenuItem find(String string, T object) {
         MenuItem rsl = null;
         Queue<TreeNode> queue = new LinkedList<>();
         TreeNode obj = (TreeNode) object;
         queue.add(obj);
         while (!queue.isEmpty()) {
             TreeNode node = queue.remove();
             if (node.getValue().toString().equals(string)) {
                 rsl = (MenuItem) node.value;
                 break;
             } else {
                 for (var el : node.getChildrens()) {
                     TreeNode nodeEl = (TreeNode) el;
                     queue.add(nodeEl);
                 }
             }
         }
         return rsl;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TreeNode> childrens) {
        this.childrens = childrens;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}

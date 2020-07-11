package ru.job4j.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        boolean rsl = false;
        ArrayList<Node<E>> listOfElem = giveQueurElem();
        for (var el : listOfElem) {
            if (el.children.size() <= 2) {
                rsl = true;
            } else {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        boolean stop = true;
        Optional<Node<E>> findParent = findBy(parent);
        Optional<Node<E>> findChild = findBy(child);
        List<Node<E>> list = null;
        if (findChild.isEmpty() && findParent.isPresent()) {
            list = findParent.get().children;
            Node<E> forvard = new Node<>(child);
            list.add(forvard);
            rsl = true;
        }
              return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        ArrayList<Node<E>> listOfElem = giveQueurElem();
        for (var el : listOfElem) {
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
        }
        return rsl;
    }

    public ArrayList<Node<E>> giveQueurElem() {
        Queue<Node<E>> data = new LinkedList<>();
        ArrayList<Node<E>> listOfElem = new ArrayList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() != 0) {
                data.addAll(el.children);
            }
            listOfElem.add(el);
        }
        return listOfElem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}
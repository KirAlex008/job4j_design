package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
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

    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        var rsl = findByPredicate(el -> el.value.equals(value));
        return rsl;
    }

    public boolean isBinary() {
        boolean nodeExistiert = true;
        var rsl = findByPredicate(el -> el.children.size() > 2);
        if (!rsl.isEmpty()) {
            nodeExistiert = false;
        }
        return nodeExistiert;
    }
}
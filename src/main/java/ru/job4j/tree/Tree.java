package ru.job4j.tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        boolean stop = true;
        Optional<Node<E>> findParent = findBy(parent);
        Optional<Node<E>> findChild = findBy(child);
        List<Node<E>> list = null;
        if (findParent.isPresent() && findChild.isEmpty()) {
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
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
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
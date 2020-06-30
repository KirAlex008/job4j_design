package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements SimpleMap<K, V> {
    private static float ratio = 0.75f;
    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;
    private int modCount = 0; // counter for iterator
    private int counter = 0; // elements number of array

    public SimpleHashMap() {
        this.hashTable = new Node[16];
        this.threshold = hashTable.length * ratio;
    }

    @Override
    public boolean insert(final K key,final V value) {
        boolean rsl = false;
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = newNode.hash();

        if (hashTable[index] == null) {
            rsl = simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList ) {
            if (keyExistButValueNew(node, newNode, value) ||
                    collisionProssessing(node, newNode, nodeList)) {
                rsl = true;
                break;
            }
        }
        if (rsl == true) {
            counter++;
            modCount++;
        }
        return rsl;
    }

    private boolean collisionProssessing(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final List<Node<K, V>> nodes) {
        boolean rsl = false;
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key)) {
            nodes.add(newNode);
            size++;
            rsl = true;
        }
        return rsl;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value) {
        boolean rsl = false;

        if (newNode.getKey().equals(nodeFromList.getKey())) {
            nodeFromList.setValue(value);
            rsl = true;
        }
        return rsl;
    }



    private void arrayDoubling() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }


    @Override
    public V get(K key) {
        V rsl = null;
        int index = hash(key);
        if (hashTable[index] != null) {

            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list ) {
                if (key.equals(node.getKey())) {
                    rsl = node.getValue();
                }
            }
        }
        return rsl;
    }

    public int size() {
        return size;
    }


    @Override
    public boolean delete(final K key) {
        boolean rsl = false;
        int index = hash(key);
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            rsl = true;
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        ListIterator<Node<K, V>> listIter = nodeList.listIterator();

        while(listIter.hasNext()) {
            if (key.equals(listIter.next().getKey())) {
                nodeList.remove(listIter.next().getKey());
                rsl = true;
            }
        }

        for (Node<K, V> node : nodeList ) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                rsl = true;
            }
        }
        if (rsl == true) {
            counter--;
            modCount++;
        }
        return rsl;
    }


    private int hash(Node<K, V> node) {
        return node.hashCode() % hashTable.length;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return Math.abs(hashCode() % hashTable.length);
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            boolean rsl = false;
            if (this == obj)
                rsl = true;
            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                rsl = (Objects.equals(value, node.value) &&
                        Objects.equals(key, node.key) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return rsl;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterArray = 0;
            int valuesCounter = 0;
            int expectedModCount = modCount;
            private int point = 0; // iterator counter
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                boolean rsl = false;

                if (expectedModCount < modCount) {
                    throw new ConcurrentModificationException();
                }
                if (valuesCounter == size)
                    rsl = false;

                if (counter == 0) {
                    rsl = false;
                }

                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    } else {
                        rsl = false;
                    }
                } else {
                    rsl = subIterator.hasNext();
                }
                return rsl;
            }

            private boolean moveToNextCell() {
                counterArray++;
                while (counterArray < hashTable.length && hashTable[counterArray] == null) {
                    counterArray++;
                }
                return counterArray < hashTable.length && hashTable[counterArray] == null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }
}
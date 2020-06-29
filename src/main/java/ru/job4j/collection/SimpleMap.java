package ru.job4j.collection;

public interface SimpleMap<K, V> extends Iterable<V> {
    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}

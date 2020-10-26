package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cash {
    Map<String, SoftReference<String>> store = new HashMap();

    public String getString(String key) {
        String rsl = null;
        Reader reader = new Reader();
        if (!store.containsKey(key)) {
            rsl = reader.wordsRead(key);
            store.put(key, new SoftReference(rsl));
        } else if (store.get(key).get() == null) {
            rsl = reader.wordsRead(key);
            store.put(key, new SoftReference(rsl));
        } else {
            rsl = store.get(key).get();
        }
        return rsl;
    }
}
package ru.job4j.statistics;

import java.util.Objects;

public class Info {
    int added;
    int deleted;
    int changed;


    public Info(int added, int deleted, int changed) {
        this.added = added;
        this.deleted = deleted;
        this.changed = changed;
    }

    @Override
    public String toString() {
        return this.added + " " + this.deleted + " " + this.deleted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return added == info.added
                && changed == info.changed
                && deleted == info.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(added, deleted, changed);
    }
}

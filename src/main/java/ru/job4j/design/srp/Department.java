package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public abstract class Department {
    private Store store;
    private Predicate<Employer> filter;

    protected Department(Store store, Predicate<Employer> filter) {
        this.store = store;
        this.filter = filter;
    }

    abstract Report createReport(String type);
    abstract List<Employer> prepareReport ();
}

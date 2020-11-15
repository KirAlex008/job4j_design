package ru.job4j.design.srp;

import java.io.IOException;
import java.util.function.Predicate;

public abstract class CommonReportEngine {

    private Store store;

    public CommonReportEngine(Store store) {
        this.store = store;
    }
    public abstract String generate(Predicate<Employer> filter) throws IOException;
}

package ru.job4j.design.srp;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class HRDepartment extends Department{

    private Store store;
    private Predicate<Employer> filter;
    private Report report;

    protected HRDepartment (Store store, Predicate<Employer> filter) {
        super(store, filter);
        this.store = store;
        this.filter = filter;
    }

    @Override
    Report createReport(String type) {
        Report report = null;
        if (type.equals("html")) {
            report = new HTMLReport();
        } else if (type.equals("string")) {
            report = new SimpleStringReport();
        } else if (type.equals("stringShortened")) {
            report = new SimpleStringReportShortened();
        }
        return report;
    }

    @Override
    List<Employer> prepareReport() {
        List<Employer> list = store.findBy(filter);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}

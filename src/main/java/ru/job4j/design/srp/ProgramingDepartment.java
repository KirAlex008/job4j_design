package ru.job4j.design.srp;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ProgramingDepartment extends Department{

    private Store store;
    private Predicate<Employer> filter;
    private Report report;

    protected ProgramingDepartment(Store store, Predicate<Employer> filter) {
        super(store, filter);
        this.store = store;
        this.filter = filter;
    }

    @Override
    public Report createReport(String type) {
        Report report = null;
        if (type.equals("html")) {
            report = new HTMLReport();
        } else if (type.equals("string")) {
            report = new SimpleStringReport();
        } else if (type.equals("xml")) {
            report = new XMLReport();
        } else if (type.equals("json")) {
            report = new JSONReport();
        }
        return report;
    }

    @Override
    public List<Employer> prepareReport () {
        List<Employer> list = store.findBy(filter);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

        public String makeReport (List < Employer > list) throws IOException {
            ProgramingDepartment department = new ProgramingDepartment(store, filter);
            report = department.createReport("html");
            var listOfElem = department.prepareReport();
            return report.generate(listOfElem);
        }
}

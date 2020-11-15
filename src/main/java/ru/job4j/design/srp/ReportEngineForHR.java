package ru.job4j.design.srp;

import java.util.Collections;
import java.util.function.Predicate;

public class ReportEngineForHR extends CommonReportEngine{

    private Store store;

    public ReportEngineForHR(Store store) {
        super(store);
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        var list = store.findBy(filter);
        Collections.sort(list, Collections.reverseOrder());
        for (Employer employee : list) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngine extends CommonReportEngine{

    private Store store;

    public ReportEngine(Store store) {
        super(store);
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
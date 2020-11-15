package ru.job4j.design.srp;

import java.io.IOException;
import java.util.function.Predicate;

public class ReportEngineForBuch extends CommonReportEngine {

    private Store store;

    public ReportEngineForBuch(Store store) {
        super(store);
        this.store = store;
    }

    private static double dollar = 60.5;

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / dollar).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
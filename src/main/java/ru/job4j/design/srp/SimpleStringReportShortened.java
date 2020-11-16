package ru.job4j.design.srp;

import java.io.IOException;
import java.util.List;

public class SimpleStringReportShortened implements Report{
    @Override
    public String generate(List<Employer> list) throws IOException {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employer employee : list) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

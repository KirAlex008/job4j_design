package ru.job4j.design.srp;

import freemarker.template.TemplateException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.function.Predicate;

public class ReportEngine {
    private Store store;

    public ReportEngine(Store store) {
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

    public static void main(String[] args) throws IOException, TemplateException, TransformerException {
        MemStore store = new MemStore();
        ReportEngineForProg reportEngine = new ReportEngineForProg(store);
        String report = reportEngine.generate(em -> true);
        System.out.println(report);
    }
}
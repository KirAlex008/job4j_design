package ru.job4j.design.srp;

import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BuchhaltungDepartmentTest {

    @Test
    public void whenForBuchGenerated() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        BuchhaltungDepartment department = new BuchhaltungDepartment(store, em -> true);
        Report report = department.createReport("string");
        var listOfElem = department.prepareReport();
        String result = report.generate(listOfElem);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(result, is(expect.toString()));
    }
}
package ru.job4j.design.srp;

import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HRDepartmentTest {
    @Test
    public void whenHRGenerated() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Egor", now, now, 80);
        store.add(worker);
        store.add(worker2);
        HRDepartment department = new HRDepartment(store, em -> em.getSalary() > 0);
        Report report = department.createReport("stringShortened");
        var listOfElem = department.prepareReport();
        String result = report.generate(listOfElem);

        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(result, is(expect.toString()));
    }

}
package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import java.io.IOException;

public class ReportEngineForProgTest {

    @Test
    public void whenProgGenerated() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngineForProg engine = new ReportEngineForProg(store);
                StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html lang=\"en\">").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("    <meta charset=\"UTF-8\">").append(System.lineSeparator())
                .append("    <title>Report</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<p>Name: ").append(worker.getName()).append("</p>").append(System.lineSeparator())
                .append("<p>Hired: ").append(worker.getHired().toString()).append("</p>").append(System.lineSeparator())
                .append("<p>Fired: ").append(worker.getFired().toString()).append("</p>").append(System.lineSeparator())
                .append("<p>Salary: ").append(String.valueOf(worker.getSalary())).append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        String result = engine.generate(em -> true);
        String expected = expect.toString();
        assertThat(result, is(expected));
    }
}
package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportEngineForProgTest {

    @Test
    public void whenOldGenerated() throws IOException, TemplateException, TransformerException {
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
                .append("    <p>Name: ").append(worker.getName()).append("</p>").append(System.lineSeparator())
                .append("    <p>Hired: ").append(worker.getHired()).append("</p>").append(System.lineSeparator())
                .append("    <p>Fired: ").append(worker.getFired()).append("</p>").append(System.lineSeparator())
                .append("    <p>Salary: ").append(worker.getSalary()).append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        String string = engine.generate(em -> em.getName().contains("Ivan"));
        String rsl = string.substring(string.length()-54);
        System.out.println(rsl + "rsl");
        System.out.println(expect.toString() + "exp");

        assertThat(rsl, is(expect.toString()));
    }
}
package ru.job4j.design.srp;

import java.io.*;
import java.util.Calendar;
import java.util.function.Predicate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import java.util.HashMap;
import java.util.Map;

public class ReportEngineForProg {
    private Store store;

    public ReportEngineForProg(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) throws IOException, TemplateException, TransformerException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("C:/projects/job4j_design/src/main/resources/"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


    // модель данных
    Map<String, Object> root = new HashMap<>();

    // шаблон
    Template temp = cfg.getTemplate("template.ftl");
    // обработка шаблона и модели данных
        Writer out  = new OutputStreamWriter(System.out);

       // StringBuilder text = new StringBuilder();
        //text.append("Name; Hired; Fired; Salary;");
        for (Employer employee : store.findBy(filter)) {
            root.put("name", employee.getName());
            root.put("hired", employee.getHired());
            root.put("fired", employee.getFired());
            root.put("salary", employee.getSalary());
        }
        // вывод в консоль

 /*       try (StringWriter out = new StringWriter()) {

            temp.process(root, out);
            System.out.println(out.getBuffer().toString());

            out.flush();
            return temp.toString();
        }*/
        temp.process(root, out);
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(), new StreamResult(writer));
        String str = writer.getBuffer().toString();
        return str;
    }

    public static void main(String[] args) throws IOException, TemplateException, TransformerException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);

        ReportEngineForProg reportEngine = new ReportEngineForProg(store);
        String report = reportEngine.generate(em -> em.getName().contains("Ivan"));
        System.out.println(report);
    }
}
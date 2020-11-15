package ru.job4j.design.srp;

import java.io.*;
import java.util.function.Predicate;
import org.apache.commons.io.FileUtils;

public class ReportEngineForProg extends CommonReportEngine{
    private Store store;

    public ReportEngineForProg(Store store) {
        super(store);
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) throws IOException {
        File htmlTemplateFile = new File("C:/projects/job4j_design/src/main/resources/template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
        String rsl = null;
        //File newHtmlFile = new File("path/new.html");
        //FileUtils.writeStringToFile(newHtmlFile, htmlString);

        for (Employer employee : store.findBy(filter)) {
            String name = employee.getName();
            String hired = employee.getHired().toString();
            String fired = employee.getFired().toString();
            String salary = String.valueOf(employee.getSalary());
            htmlString = htmlString.replace("${name}", name);
            htmlString = htmlString.replace("${hired}", hired);
            htmlString = htmlString.replace("${fired}", fired);
            htmlString = htmlString.replace("${salary}", salary);
            rsl = htmlString;
        }
        return rsl;
    }

}
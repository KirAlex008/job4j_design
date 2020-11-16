package ru.job4j.design.srp;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class HTMLReport implements Report{
    @Override
    public String generate(List<Employer> list) throws IOException {
        File htmlTemplateFile = new File("C:/projects/job4j_design/src/main/resources/template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
        //File newHtmlFile = new File("path/new.html");
        //FileUtils.writeStringToFile(newHtmlFile, htmlString);
        String rsl = null;
        for (Employer employee : list) {
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
